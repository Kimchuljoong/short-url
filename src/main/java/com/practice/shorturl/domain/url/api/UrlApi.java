package com.practice.shorturl.domain.url.api;

import java.util.Optional;

import com.practice.shorturl.domain.url.model.UrlDto;
import com.practice.shorturl.domain.url.model.UrlEntity;
import com.practice.shorturl.domain.url.service.UrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
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

    @PostMapping("/url/add")
    public ResponseEntity<UrlEntity> addUrl(@RequestBody UrlDto urldto) {

        urlService.addUrl(urldto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
