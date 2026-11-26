package com.iscod.coworkia.services;

import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.Site;
import com.iscod.coworkia.repositories.SiteRepository;

@Service
public class SiteService extends BaseService<Site, Long> {
	
	public SiteService(SiteRepository repository) {
        super(repository);
    }
}
