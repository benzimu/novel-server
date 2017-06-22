package com.hjj.ben.controller;

import com.hjj.ben.model.NovelChapters;
import com.hjj.ben.service.INovelChaptersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ben on 6/22/17.
 */

@Controller
@RequestMapping("/chapters")
public class NovelChaptersController {

    @Resource
    private INovelChaptersService novelChaptersService;

    @RequestMapping(method = RequestMethod.GET, value = "/catalog/{novelDetailId}")
    public ModelAndView getCatalog(@PathVariable Integer novelDetailId) {
        ModelAndView view = new ModelAndView("chapters/catalog");
        List<NovelChapters> list = novelChaptersService.getCatalogByDetailId(novelDetailId);
        System.out.println("catalogList: " + list);
        view.addObject("catalogList", list);
        return view;
    }

}
