package com.hjj.ben.service.impl;

import com.hjj.ben.dao.IBaseDao;
import com.hjj.ben.model.NovelChapters;
import com.hjj.ben.service.INovelChaptersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ben on 6/22/17.
 */

@Service
public class NovelChaptersService implements INovelChaptersService {

    @Resource
    private IBaseDao baseDao;

    public List<NovelChapters> getCatalogByDetailId(Integer novelDetailId, String reverseFlag) {
        List<NovelChapters> list = (List<NovelChapters>) baseDao.getCatalog(novelDetailId, reverseFlag, NovelChapters.class);
        return list;
    }

    public NovelChapters getChapterById(Integer chapterId) {
        NovelChapters novelChapters = (NovelChapters) baseDao.getById(chapterId, NovelChapters.class);
        return novelChapters;
    }

    public NovelChapters getLastChapter(Integer curChapterResId, Integer novelDetailId) {
        Object obj = baseDao.getLastItem(curChapterResId, novelDetailId, NovelChapters.class);
        if (obj != null) {
            return (NovelChapters)obj;
        }
        return null;
    }

    public NovelChapters getNextChapter(Integer curChapterResId, Integer novelDetailId) {
        Object obj = baseDao.getNextItem(curChapterResId, novelDetailId, NovelChapters.class);
        if (obj != null) {
            return (NovelChapters)obj;
        }
        return null;
    }

}
