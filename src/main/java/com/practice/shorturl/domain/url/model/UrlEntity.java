package com.practice.shorturl.domain.url.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class UrlEntity {

    @Id
    private String id;

    private String destination;

    private LocalDateTime createAt;

    private String creator;
}
