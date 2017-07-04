package com.hjj.ben.controller;

import com.hjj.ben.annotation.SystemControllerLog;
import com.hjj.ben.model.NovelDetail;
import com.hjj.ben.service.INovelDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(NovelDetailController.class);

    @Resource
    private INovelDetailService novelDetailService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @SystemControllerLog(description = "获取小说详情列表")
    public ModelAndView list() {
        logger.info("#####this is NovelDetailController#####");
        ModelAndView view = new ModelAndView("detail/list");
        List<NovelDetail> list = novelDetailService.getAll();
        view.addObject("novelDetailList", list);
        return view;
    }

}
