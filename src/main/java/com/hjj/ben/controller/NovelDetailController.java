package com.hjj.ben.controller;

import com.hjj.ben.model.NovelDetail;
import com.hjj.ben.service.INovelDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ben on 6/22/17.
 */
@Controller
@RequestMapping("/detail")
public class NovelDetailController {

    @Resource
    private INovelDetailService novelDetailService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public ModelAndView list() {
        ModelAndView view = new ModelAndView("detail/list");
        List<NovelDetail> list = novelDetailService.getAll();
        view.addObject("novelDetailList", list);
        return view;
    }

}
