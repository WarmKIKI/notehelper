package com.cn.manage.service.impl;

import com.cn.manage.dao.TaglibDao;
import com.cn.manage.service.TaglibQueryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value="taglibQueryService")
public class TaglibQueryServiceImpl implements TaglibQueryService {
    @Resource(name="taglibDao")
    private TaglibDao taglibDao;
    public List<Map<Integer, String>> queryTaglib() {
        return taglibDao.queryTaglib();
    }
}
