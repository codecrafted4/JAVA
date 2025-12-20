package com.example.DailyUpdates.Service;

import com.example.DailyUpdates.dto.NewsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {
    RestTemplate restTemplate = new RestTemplate();

    private final String  BASE_URL = "https://newsapi.org/v2";
    private final String API_KEY = "36c337ae9e5043f2b2e37b39da4142c5";

    public NewsResponse getNewsByCountry(String countryCode) {
        String url = BASE_URL+"/top-headlines?country="+countryCode+"&apiKey="+API_KEY;
        NewsResponse response= restTemplate.getForObject(url, NewsResponse.class);
        return response;
    }
}
