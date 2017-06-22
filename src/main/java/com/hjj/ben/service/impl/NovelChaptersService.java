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

    public List<NovelChapters> getCatalogByDetailId(Integer novelDetailId) {
        List<NovelChapters> list = (List<NovelChapters>) baseDao.getCatalog(novelDetailId, NovelChapters.class);
        return list;
    }

}
