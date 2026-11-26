package com.iscod.coworkia.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	
	@ManyToOne
	@JoinColumn(name="zone_id")
	@JsonBackReference
	private Zone zone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", code=" + code + ", zone=" + zone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, id, zone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(zone, other.zone);
	}
	
	public Post() {
	}

	public Post(String code, Zone zone) {
		this.code = code;
		this.zone = zone;
	}
}
