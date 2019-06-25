package net.mahdirazavi.app.githubanalyzer.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.mahdirazavi.app.githubanalyzer.model.AnalyzeReport;
import net.mahdirazavi.app.githubanalyzer.model.GithubSession;
import net.mahdirazavi.app.githubanalyzer.model.RepositorySearchResult;
import net.mahdirazavi.app.githubanalyzer.server.service.GitHubService;
import org.eclipse.egit.github.core.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

/**
 * The Github client controller.
 */
@RestController
@Validated
@RequestMapping("/repos")
public class GitHubClientController {
    @Autowired
    private GitHubService githubService;
    @Autowired
    private GithubSession githubSession;

    /**
     * Gets all Repository.
     *
     * @return the repos
     * @throws Exception the exception
     */
    @GetMapping
    public List<Repository> getRepos() throws Exception {
        return githubService.listRepositories();
    }

    /**
     * Gets a {@link Repository} by id
     *
     * @param id the id
     * @return the repos
     * @throws Exception the exception
     */
    @GetMapping("/{id}")
    public Repository getRepos(@PathVariable @Min(1) Long id) throws Exception {
        return githubService.getRepository(id);
    }

    /**
     * Search  for Repository with a keyword.
     *
     * @param search the search
     * @return the repository search result
     * @throws Exception the exception
     */
    @GetMapping("/lookup/{search}")
    public RepositorySearchResult searchRepos(@PathVariable String search) throws Exception {
        return githubService.searchRepositories(search);
    }

    /**
     * Analyze a Repository by it's id.
     *
     * @param repoId the repo id
     * @return the analyze report
     * @throws Exception the exception
     */
    @GetMapping(path = "/analyze/{repoId}")
    public AnalyzeReport analyzeRepo(@PathVariable @Min(1) Long repoId) throws Exception {
        return githubService.analyzeRepositories(repoId);
    }

    /**
     * Analyze a Repository by it's owner and name.
     *
     * @param owner    the owner
     * @param repoName the repo name
     * @return the analyze report
     * @throws Exception the exception
     */
    @GetMapping(path = "/analyze")
    public AnalyzeReport analyzeRepo(@RequestParam("owner") String owner, @RequestParam("repo") String repoName) throws Exception {
        return githubService.analyzeRepositories(owner, repoName);
    }


    /**
     * Gets access token.
     *
     * @param code the code
     * @return the access token
     * @throws Exception the exception
     */
    @GetMapping(path = "/authenticate")
    public ResponseEntity getAccessToken(@RequestParam("code") String code) throws Exception {
        String result = githubService.authorize(githubSession.getClientId(), githubSession.getClientSecret(), code);
        JsonObject jsonObject = new Gson().fromJson(result, JsonObject.class);
        Optional<JsonElement> accessTokenElement = Optional.ofNullable(jsonObject.get("access_token"));
        if (accessTokenElement.isPresent()) {
            githubSession.setUserAccessToken(accessTokenElement.get().getAsString());
            return ResponseEntity.ok("Authentication successful, You can use services.");
        } else return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication failed.");
    }
}
