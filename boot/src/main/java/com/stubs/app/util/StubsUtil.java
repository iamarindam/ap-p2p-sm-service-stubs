package com.stubs.app.util;

import okhttp3.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StubsUtil {

    public static HttpHeaders fetchHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Correlation-ID", UUID.randomUUID().toString());
        headers.set("Content-Type","application/json");
        return headers;
    }

    public static RestTemplate fetchRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;

    }
}
