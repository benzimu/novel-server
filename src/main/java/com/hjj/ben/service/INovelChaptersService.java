package com.hjj.ben.service;

import com.hjj.ben.model.NovelChapters;

import java.util.List;

/**
 * Created by ben on 6/22/17.
 */
public interface INovelChaptersService {

    /**
     * 通过小说详情ID获取章节目录
     * @param novelDetailId
     * @param reverseFlag
     * @return
     */
    List<NovelChapters> getCatalogByDetailId(Integer novelDetailId, String reverseFlag);

    NovelChapters getChapterById(Integer chapterId);
}
