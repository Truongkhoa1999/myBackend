package com.rest_api.fs14backend.statics;

import com.rest_api.fs14backend.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StaticsService {
    @Autowired
    StaticsRepository staticsRepository;
    public Statics createStatics (Statics statics) {
        return staticsRepository.save(statics);
    }
    public Statics findStaticsById(UUID staticsId) {
        return staticsRepository.findById(staticsId).orElse(null);
    }
    public List<Statics> findAllStatics () {
        return staticsRepository.findAll();
    }


}
