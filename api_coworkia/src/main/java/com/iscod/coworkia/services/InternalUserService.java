package com.iscod.coworkia.services;

import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.InternalUser;
import com.iscod.coworkia.repositories.InternalUserRepository;

@Service
public class InternalUserService extends BaseService<InternalUser, Long> {
	
	public InternalUserService(InternalUserRepository repository) {
        super(repository);
    }
}
