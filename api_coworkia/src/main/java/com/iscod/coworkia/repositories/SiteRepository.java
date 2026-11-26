package com.iscod.coworkia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iscod.coworkia.entities.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

}
