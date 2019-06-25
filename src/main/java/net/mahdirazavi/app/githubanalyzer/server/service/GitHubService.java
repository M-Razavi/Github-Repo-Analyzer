package net.mahdirazavi.app.githubanalyzer.server.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.mahdirazavi.app.githubanalyzer.client.AuthInterface;
import net.mahdirazavi.app.githubanalyzer.client.RepositoryInterface;
import net.mahdirazavi.app.githubanalyzer.client.APIConfiguration;
import net.mahdirazavi.app.githubanalyzer.model.*;
import okhttp3.ResponseBody;
import org.eclipse.egit.github.core.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * The type Github service.
 */
@Service
public class GitHubService {

    @Autowired
    private GithubSession githubSession;

    private RepositoryInterface githubClientService;
    private AuthInterface githubAuthService;

    /**
     * Instantiates a new Github service.
     */
    public GitHubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConfiguration.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofitAuth = new Retrofit.Builder()
                .baseUrl(APIConfiguration.AUTH_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        githubClientService = retrofit.create(RepositoryInterface.class);
        githubAuthService = retrofitAuth.create(AuthInterface.class);
    }

    /**
     * Check return error of github api
     *
     * @param successful
     * @param responseBody
     * @throws Exception
     */
    private void checkError(boolean successful, ResponseBody responseBody) throws Exception {
        if (!successful) {
            throw new Exception(responseBody != null
                    ? responseBody.string() : "Unknown error");
        }
    }

    /**
     * List repositories list.
     *
     * @return the list
     * @throws Exception the exception
     */
    public List<Repository> listRepositories() throws Exception {
        Call<List<Repository>> retrofitCall = githubClientService.listPublicRepos(APIConfiguration.API_VERSION_ACCEPT);
        Response<List<Repository>> response = retrofitCall.execute();
        checkError(response.isSuccessful(), response.errorBody());
        return response.body();
    }

    /**
     * Search repositories with keyword.
     *
     * @param searchQuery the search query
     * @return the repository search result
     * @throws Exception the exception
     */
    public RepositorySearchResult searchRepositories(String searchQuery) throws Exception {
        Call<RepositorySearchResult> retrofitCall = githubClientService.searchPublicRepos(APIConfiguration.API_SEARCH_ACCEPT, searchQuery);
        Response<RepositorySearchResult> response = retrofitCall.execute();
        checkError(response.isSuccessful(), response.errorBody());
        return response.body();
    }

    /**
     * Authorize on github.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @param code         the code
     * @return the string
     * @throws Exception the exception
     */
    public String authorize(String clientId, String clientSecret, String code) throws Exception {
        Call<ResponseBody> retrofitCall = githubAuthService.authorize(clientId, clientSecret, code, "application/x-www-form-urlencoded", APIConfiguration.JSON_CONTENT_TYPE);
        Response<ResponseBody> response = retrofitCall.execute();
        checkError(response.isSuccessful(), response.errorBody());
        return response.body().string();
    }


    /**
     * Analyze repositories with it's id.
     *
     * @param repoId the repo id
     * @return the analyze report
     * @throws Exception the exception
     */
    public AnalyzeReport analyzeRepositories(Long repoId) throws Exception {
        Repository repository = getRepository(repoId);
        String owner = repository.getOwner().getLogin();
        String repoName = repository.getName();
        return analyzeRepositories(owner, repoName);
    }

    /**
     * Analyze repositories with it's name and owner.
     *
     * @param owner    the owner
     * @param repoName the repo name
     * @return the analyze report
     * @throws Exception the exception
     */
    public AnalyzeReport analyzeRepositories(String owner, String repoName) throws Exception {
        Call<List<Contributor>> retrofitCallContributors = githubClientService.getRepoContributors(APIConfiguration.API_VERSION_ACCEPT, APIConfiguration.JSON_CONTENT_TYPE, owner, repoName);
        Response<List<Contributor>> contributorResponse = retrofitCallContributors.execute();
        checkError(contributorResponse.isSuccessful(), contributorResponse.errorBody());
        Call<List<Commit>> retrofitCallCommits = githubClientService.getRepoCommits(APIConfiguration.API_VERSION_ACCEPT, owner, repoName);
        Response<List<Commit>> commitResponse = retrofitCallCommits.execute();
        checkError(commitResponse.isSuccessful(), commitResponse.errorBody());
        return new AnalyzeReport(contributorResponse.body(), commitResponse.body());
    }

    /**
     * Gets repository by id.
     *
     * @param repoId the repo id
     * @return the repository
     * @throws Exception the exception
     */
    public Repository getRepository(Long repoId) throws Exception {
        Call<Repository> retrofitCallRepo = githubClientService.getPublicRepo(APIConfiguration.API_VERSION_ACCEPT, APIConfiguration.JSON_CONTENT_TYPE, repoId.toString());
        Response<Repository> repositoryResponse = retrofitCallRepo.execute();
        checkError(repositoryResponse.isSuccessful(), repositoryResponse.errorBody());
        return repositoryResponse.body();
    }
}