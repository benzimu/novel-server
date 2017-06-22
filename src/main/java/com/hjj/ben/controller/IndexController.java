package com.hjj.ben.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ben on 6/22/17.
 */

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("index", "this is novelserver index page!");
        return view;
    }

}
