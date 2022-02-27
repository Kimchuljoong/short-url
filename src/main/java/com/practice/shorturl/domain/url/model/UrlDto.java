package com.practice.shorturl.domain.url.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UrlDto {

    String subUrl;

    String destination;

    String regPr;

}
