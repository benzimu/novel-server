package com.hjj.ben.controller;

import com.hjj.ben.model.NovelChapters;
import com.hjj.ben.model.NovelDetail;
import com.hjj.ben.service.INovelChaptersService;
import com.hjj.ben.service.INovelDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Resource
    private INovelDetailService novelDetailService;

    @RequestMapping(method = RequestMethod.GET, value = "/catalog/{novelDetailId}")
    public ModelAndView getCatalog(@PathVariable Integer novelDetailId, @RequestParam(value = "reverseFlag", required = false, defaultValue = "0") Integer reverseFlag) {
        String reverseTag = reverseFlag == 0 ? "asc" : "desc";

        ModelAndView view = new ModelAndView("chapters/catalog");
        List<NovelChapters> list = novelChaptersService.getCatalogByDetailId(novelDetailId, reverseTag);
        view.addObject("catalogList", list);

        NovelDetail novelDetail = novelDetailService.getById(novelDetailId);
        view.addObject("novelDetail", novelDetail);

        view.addObject("reverseFlag", reverseFlag == 0 ? 1 : 0);
        return view;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{chapterId}")
    public ModelAndView getChapterById(@PathVariable Integer chapterId) {
        NovelChapters novelChapters = novelChaptersService.getChapterById(chapterId);
        ModelAndView view = new ModelAndView("chapters/chapter");
        view.addObject("chapter", novelChapters);
        return view;
    }

}
