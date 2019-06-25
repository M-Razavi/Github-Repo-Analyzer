package net.mahdirazavi.app.githubanalyzer.exception;

/**
 * <h1>AuthException</h1>
 * The Github AuthException model
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/14/2019
 */

public class AuthError {
    private String errorCode;
    private String errorDesc;
    private String errorUri;

    public AuthError(String errorCode, String errorDesc, String errorUri) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
        this.errorUri = errorUri;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getErrorUri() {
        return errorUri;
    }

    public void setErrorUri(String errorUri) {
        this.errorUri = errorUri;
    }
}
