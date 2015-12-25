package by.webproject.hirs.cotrollers;

import java.util.concurrent.atomic.AtomicLong;
import by.webproject.hirs.entityes.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public ModelAndView greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ModelAndView model = new ModelAndView("page");
        model.addObject("greeting", new Greeting(counter.incrementAndGet(),
                String.format(template, name)));
        return model;


    }
}