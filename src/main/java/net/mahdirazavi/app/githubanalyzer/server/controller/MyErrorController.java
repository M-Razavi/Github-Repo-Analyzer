package net.mahdirazavi.app.githubanalyzer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <h1>dsfgfh</h1>
 * The dsfgfh
 * <p>
 *
 * @author Mahdi Razavi
 * @version 1.0
 * @since 6/11/2019
 */

@Controller
public class MyErrorController implements ErrorController {



    @Override
    @RequestMapping("/error")
    @ResponseBody
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return "Error occurred and details sent to admin. Please try later.";
    }

}
