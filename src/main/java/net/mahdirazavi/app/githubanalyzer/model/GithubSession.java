package net.mahdirazavi.app.githubanalyzer.model;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;
import java.util.Random;

/**
 * <h1>GithubSession</h1>
 * The GithubSession store some information for each session
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */
public class GithubSession {
    @Value("${github_client_id}")
    private String clientId;
    @Value("${github_client_secret}")
    private String clientSecret;

    private String randomValue;

    private String userAccessToken;

    @Value("${github_client_response_uri}")
    private String requestUri;

    /**
     * Instantiates a new Github session.
     */
    public GithubSession() {
        randomValue = String.valueOf(new Random(LocalTime.now().toNanoOfDay()).nextInt());
    }

    /**
     * Gets user access token.
     *
     * @return the user access token
     */
    public String getUserAccessToken() {
        return userAccessToken;
    }

    /**
     * Sets user access token.
     *
     * @param userAccessToken the user access token
     */
    public void setUserAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Gets client secret.
     *
     * @return the client secret
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Gets random value.
     *
     * @return the random value
     */
    public String getRandomValue() {
        return randomValue;
    }

    /**
     * Gets request uri.
     *
     * @return the request uri
     */
    public String getRequestUri() {
        return requestUri;
    }
}
