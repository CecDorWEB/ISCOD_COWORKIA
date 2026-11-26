package com.iscod.coworkia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iscod.coworkia.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
