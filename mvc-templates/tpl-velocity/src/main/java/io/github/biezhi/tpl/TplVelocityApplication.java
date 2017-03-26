package io.github.biezhi.tpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by biezhi on 2017/3/26.
 */
@SpringBootApplication
@Controller
public class TplVelocityApplication {

    @GetMapping(value = {"/", "/index"})
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("name", "biezhi");
        mav.setViewName("index");
        return mav;
    }

    public static void main(String[] args) {
        SpringApplication.run(TplVelocityApplication.class, args);
    }

}
