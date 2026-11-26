package com.iscod.coworkia.services;

import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.Zone;
import com.iscod.coworkia.repositories.ZoneRepository;

@Service
public class ZoneService extends BaseService<Zone, Long> {
	public ZoneService(ZoneRepository repository) {
        super(repository);
    }
}
