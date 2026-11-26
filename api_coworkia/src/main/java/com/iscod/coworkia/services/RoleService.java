package com.iscod.coworkia.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.iscod.coworkia.entities.Role;

@Service
public class RoleService extends BaseService<Role, Long> {

	protected RoleService(JpaRepository<Role, Long> repository) {
		super(repository);
	}

}
