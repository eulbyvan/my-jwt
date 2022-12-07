package com.enigmacamp.util;

import com.enigmacamp.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 07/12/2022
 */

@Component
public class RestClient {
    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String get(String url) {
        try {
            ResponseEntity result = restTemplate.getForEntity(url, String.class);

            return result.getBody().toString();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) throw new UnauthorizedException(e.getMessage());
            if(e.getStatusCode().equals(HttpStatus.NOT_FOUND)) throw new RuntimeException(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
