package com.iscod.coworkia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iscod.coworkia.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long>{

}
