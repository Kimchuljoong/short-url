package com.practice.shorturl.domain.url.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.util.Assert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UrlEntity {

    @Builder
    public UrlEntity(String subUrl, String destination, String status, String creator) {

        Assert.hasText(subUrl, "subUrl in empty");
        Assert.hasText(destination, "destination in empty");
        Assert.hasText(status, "status in empty");
        Assert.hasText(creator, "creator in empty");

        this.subUrl = subUrl;
        this.destination = destination;
        this.status = status;
        this.creator = creator;
    }

    @Builder
    public UrlEntity(String id, String subUrl, String status) {
        this.id = id;
        this.subUrl = subUrl;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String subUrl;

    private String destination;

    private String status;

    @CreatedDate
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreatedBy
    private String creator;
}
