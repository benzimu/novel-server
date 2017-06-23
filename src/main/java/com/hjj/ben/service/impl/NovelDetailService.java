package com.hjj.ben.service.impl;

import com.hjj.ben.dao.IBaseDao;
import com.hjj.ben.model.NovelDetail;
import com.hjj.ben.service.INovelDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ben on 6/22/17.
 */

@Service
public class NovelDetailService implements INovelDetailService {

    @Resource
    private IBaseDao baseDao;

    public List<NovelDetail> getAll() {
        List<NovelDetail> list = (List<NovelDetail>) baseDao.getAll(NovelDetail.class);
        return list;
    }

    public NovelDetail getById(Integer id) {
        NovelDetail novelDetail = (NovelDetail) baseDao.getById(id, NovelDetail.class);
        return novelDetail;
    }
}
