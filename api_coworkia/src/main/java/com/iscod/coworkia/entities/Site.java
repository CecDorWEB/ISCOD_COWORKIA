package com.iscod.coworkia.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Site {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	//1 site peut avoir plusieurs zones
	@OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Zone> zones = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	@Override
	public String toString() {
		return "Site [id=" + id + ", name=" + name + ", zones=" + zones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, zones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Site other = (Site) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(zones, other.zones);
	}

	public Site() {
	}

	public Site(String name) {
		this.name = name;
	}
	
}
