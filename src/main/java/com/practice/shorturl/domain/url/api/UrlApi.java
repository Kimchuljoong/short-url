package com.practice.shorturl.domain.url.api;

import java.util.Optional;

import com.practice.shorturl.domain.url.model.UrlEntity;
import com.practice.shorturl.domain.url.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UrlApi {

    @Autowired
    UrlService urlService;

    @GetMapping("/{subUrl}")
    public RedirectView getRedirect(@PathVariable("subUrl") String subUrl) {

        String id = subUrl;
        Optional<UrlEntity> urlEntity = urlService.getRedirect(id);

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(urlEntity.isEmpty() ? "" : urlEntity.get().getDestination());

        return redirectView;

    }
}
