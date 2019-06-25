package net.mahdirazavi.app.githubanalyzer.server.controller;

import net.mahdirazavi.app.githubanalyzer.exception.AuthError;
import net.mahdirazavi.app.githubanalyzer.model.GithubSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>Index</h1>
 * The Index controller
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/13/2019
 */
@RestController()
public class IndexController {

    @Autowired
    private GithubSession githubSession;

    @GetMapping(path = "/", params = {"error", "error_description", "error_uri"})
    public ResponseEntity getErrorCode(@RequestParam("error") String errorCode, @RequestParam("error_description") String errorDesc, @RequestParam("error_uri") String errorUri) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuthError(errorCode, errorDesc, errorUri));
    }

    @GetMapping(path = "/")
    public ResponseEntity index() {
        if (githubSession.getUserAccessToken() != null) {
            return ResponseEntity.ok("You can use service.<a href=\"/swagger-ui.html\">Api Documentation</a>");
        } else {
            return ResponseEntity.ok("Hello to Github Analyzer!<br/> please authenticate with github to use services. <a href=\"https://github.com/login/oauth/authorize?client_id=" + githubSession.getClientId().trim() + "\">Github Authorize</a>");
        }
    }
}
