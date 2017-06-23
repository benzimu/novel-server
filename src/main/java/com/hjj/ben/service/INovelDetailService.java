package com.hjj.ben.service;

import com.hjj.ben.model.NovelDetail;

import java.util.List;

/**
 * Created by ben on 6/22/17.
 */
public interface INovelDetailService {
    /**
     * 获取小说列表
     * @return
     */
    List<NovelDetail> getAll();

    /**
     * 通过小说id获取小说详情
     * @param id
     * @return
     */
    NovelDetail getById(Integer id);
}
