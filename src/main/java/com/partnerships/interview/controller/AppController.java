package com.partnerships.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AppController
 *
 * @author christian.valencia
 * @since 02/13/2019
 */
@Controller
public class AppController {

    /**
     * home redirect
     *
     * @param modal
     * @return
     */
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title", "CRUD Example");
        return "index";
    }

    /**
     * partial handler
     *
     * @param page
     * @return
     */
    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }

}
