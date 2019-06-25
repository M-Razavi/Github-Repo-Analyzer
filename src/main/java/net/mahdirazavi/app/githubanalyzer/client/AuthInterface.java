package net.mahdirazavi.app.githubanalyzer.client;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * The interface for Github Authentication.
 */
public interface AuthInterface {

    /**
     * Authorize call.
     *
     * @param clientId     the client id
     * @param clientSecret the client secret
     * @param code         the code
     * @param contentType  the content type
     * @param accept       the accept
     * @return the call
     */
    @FormUrlEncoded
    @POST("login/oauth/access_token")
    Call<ResponseBody> authorize(@Field("client_id") String clientId, @Field("client_secret") String clientSecret, @Field("code") String code
            , @Header("Content-Type") String contentType
            , @Header("Accept") String accept);
}