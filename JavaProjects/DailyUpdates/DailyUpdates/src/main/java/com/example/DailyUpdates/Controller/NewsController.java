package com.example.DailyUpdates.Controller;

import com.example.DailyUpdates.Service.NewsService;
import com.example.DailyUpdates.dto.NewsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/news")

public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping
    public ResponseEntity getNewsByCountry(@RequestParam(value ="country",required = false,defaultValue = "ind") String countryCode){
        NewsResponse resopnse =  newsService.getNewsByCountry(countryCode);
        return new ResponseEntity(resopnse, HttpStatus.OK);

    }
}
