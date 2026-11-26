package com.iscod.coworkia.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Zone {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Size(min = 3, message = "L'acronyme est composé des 2 premières lettre de la zone et d'un chiffre.")
	private String acronyme;
	
	@ManyToOne
	@JoinColumn(name = "site_id")
	@JsonBackReference
	private Site site;
	
	@OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Post> posts = new ArrayList<>();

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

	public String getAcronyme() {
		return acronyme;
	}

	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Zone [id=" + id + ", name=" + name + ", acronyme=" + acronyme + ", site=" + site + ", posts=" + posts
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(acronyme, id, name, posts, site);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zone other = (Zone) obj;
		return Objects.equals(acronyme, other.acronyme) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(posts, other.posts)
				&& Objects.equals(site, other.site);
	}

	public Zone() {
	}
	
	public Zone(String name, String acronyme, Site site) {
		this.name = name;
		this.acronyme = acronyme;
		this.site = site;
	}
}
