package com.practice.shorturl.domain.url.repository;

import java.util.List;
import java.util.Optional;

import com.practice.shorturl.domain.url.model.UrlEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, String> {

    Optional<UrlEntity> findById(String id);

    List<UrlEntity> findUrlEntitiesBycreator(String creator);

}
