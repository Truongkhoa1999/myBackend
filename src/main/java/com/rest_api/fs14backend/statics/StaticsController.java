package com.rest_api.fs14backend.statics;

import com.rest_api.fs14backend.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/statics")
public class StaticsController {
    @Autowired
    StaticsService staticsService;
    @Autowired
    StaticsRepository staticsRepository;
    @GetMapping("/")
    public List<Statics> getStatics() {
        List<Statics> statics = staticsService.findAllStatics ();
        return statics;
    }
    @PostMapping("/")
    public Statics createStatics(@RequestBody Statics statics) {
        return staticsRepository.save(statics);
    }

    @PutMapping("/clicks/{id}")
    public void updateClicks(@PathVariable UUID id) {
        Statics statics = staticsRepository.findById(id).orElse(null);
        if (statics != null) {
            statics.setClicks(statics.getClicks() + 1);
            staticsRepository.save(statics);
        }
    }
}
