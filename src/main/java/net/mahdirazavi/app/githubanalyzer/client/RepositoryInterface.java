package net.mahdirazavi.app.githubanalyzer.client;

import net.mahdirazavi.app.githubanalyzer.model.Commit;
import net.mahdirazavi.app.githubanalyzer.model.Contributor;
import net.mahdirazavi.app.githubanalyzer.model.RepositorySearchResult;
import org.eclipse.egit.github.core.Repository;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

/**
 * The interface for fetching some public information from Github API.
 */
public interface RepositoryInterface {
    /**
     * List public repos call.
     *
     * @param apiVersionSpec the api version spec
     * @return the call
     */
    @GET("repositories")
    Call<List<Repository>> listPublicRepos(@Header("Accept") String apiVersionSpec);

    /**
     * Gets public repo.
     *
     * @param apiVersionSpec the api version spec
     * @param contentType    the content type
     * @param repoId         the repo id
     * @return the public repo
     */
    @GET("repositories/{id}")
    Call<Repository> getPublicRepo(@Header("Accept") String apiVersionSpec,
                                   @Header("Content-Type") String contentType,
                                   @Path("id") String repoId);

    /**
     * Gets repo contributors.
     *
     * @param apiVersionSpec the api version spec
     * @param contentType    the content type
     * @param repoOwner      the repo owner
     * @param repoName       the repo name
     * @return the repo contributors
     */
    @GET("repos/{owner}/{repo}/contributors?page=1&per_page=1000")
    Call<List<Contributor>> getRepoContributors(@Header("Accept") String apiVersionSpec,
                                                @Header("Content-Type") String contentType,
                                                @Path("owner") String repoOwner,
                                                @Path("repo") String repoName);

    /**
     * Gets repo commits.
     *
     * @param apiVersionSpec the api version spec
     * @param repoOwner      the repo owner
     * @param repoName       the repo name
     * @return the repo commits
     */
    @GET("repos/{owner}/{repo}/commits?page=1&per_page=100")
    Call<List<Commit>> getRepoCommits(@Header("Accept") String apiVersionSpec,
//                                          @Header("Content-Type") String contentType,
                                      @Path("owner") String repoOwner,
                                      @Path("repo") String repoName);

    /**
     * Search public repos call.
     *
     * @param apiVersionSpec the api version spec
     * @param searchQuery    the search query
     * @return the call
     */
    @GET("search/repositories")
    Call<RepositorySearchResult> searchPublicRepos(@Header("Accept") String apiVersionSpec,
                                                   @Query("q") String searchQuery);

    /**
     * Gets access token.
     *
     * @param repo           the repo
     * @param accessToken    the access token
     * @param apiVersionSpec the api version spec
     * @param contentType    the content type
     * @return the access token
     */
    @POST("/login/oauth/access_token")
    Call<Repository> getAccessToken(@Body Repository repo, @Header("Authorization") String accessToken,
                                    @Header("Accept") String apiVersionSpec,
                                    @Header("Content-Type") String contentType);

}