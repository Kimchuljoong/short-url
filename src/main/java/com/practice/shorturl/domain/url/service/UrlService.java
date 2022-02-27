package com.practice.shorturl.domain.url.service;

import java.util.Optional;

import com.practice.shorturl.domain.url.model.UrlDto;
import com.practice.shorturl.domain.url.model.UrlEntity;
import com.practice.shorturl.domain.url.repository.UrlRepository;
import com.practice.shorturl.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Optional<UrlEntity> getRedirect(String id) {

        Optional<UrlEntity> urlEntity = urlRepository.findById(id);

        return urlEntity;
    }

    public void addUrl(UrlDto urlDto) {

        String subUrl = Utils.generateShortUrl(4);

        UrlEntity newUrlEntity = UrlEntity.builder()
                .subUrl(subUrl)
                .destination(urlDto.getDestination())
                .creator(urlDto.getRegPr())
                .build();

        urlRepository.save(newUrlEntity);
    }

}
