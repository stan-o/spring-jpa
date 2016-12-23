package com.so.webblog.service;

import com.so.webblog.domain.Postings;
import com.so.webblog.domain.PostingsDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostingsServiceImpl implements PostingsService {
    
    @Autowired
    private PostingsDao postingsDao;

    @Override
    public Postings byId(Integer id) {
        return postingsDao.byId(id);
    }

    @Override
    public Integer save(Postings object) {
        return (Integer)postingsDao.save(object);
    }

    @Override
    public void update(Postings object) {
        postingsDao.update(object);
    }

    @Override
    public void delete(Postings object) {
        postingsDao.remove(object);
    }

    @Override
    public List<Postings> list() {
        return postingsDao.list();
    }
    
}
