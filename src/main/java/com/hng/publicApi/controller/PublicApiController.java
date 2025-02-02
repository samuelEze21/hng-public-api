package com.hng.publicApi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class PublicApiController {

    @GetMapping
    public Map<String, String> getApiResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("email", "nwabuezesamuel21@gmail.com");
        response.put("current_datetime", ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        response.put("github_url", "https://github.com/samuelEze21/hng-public-api");
        return response;
    }
}
