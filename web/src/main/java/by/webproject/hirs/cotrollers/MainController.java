package by.webproject.hirs.cotrollers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by hirs on 15.11.2015.
 */

@Controller
@RequestMapping("/")
public class MainController {

    private static Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String hello() {
        logger.info("hello!");
        return "redirect:/buys";
    }
}
