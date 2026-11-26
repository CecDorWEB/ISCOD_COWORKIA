package com.iscod.coworkia.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime startingDate;
	
	private LocalDateTime endingDate;
	
	private LocalDateTime reservedOn = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "internalUser_id")
	private InternalUser user;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getStartingDateTime() {
		return startingDate;
	}

	public void setStartingDateTime(LocalDateTime startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDateTime getEndingDate() {
		return endingDate;
	}

	public void setEndingDateTime(LocalDateTime endingDate) {
		this.endingDate = endingDate;
	}

	public LocalDateTime getReservedOn() {
		return reservedOn;
	}

	public void setReservedOn(LocalDateTime reservedOn) {
		this.reservedOn = reservedOn;
	}

	public InternalUser getUser() {
		return user;
	}

	public void setUser(InternalUser user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", startingDateTime=" + startingDate + ", endingDate=" + endingDate
				+ ", reservedOn=" + reservedOn + ", user=" + user + ", post=" + post + "]";
	}
	
	public Reservation() {
	}

	public Reservation(LocalDateTime startingDate, LocalDateTime endingDate, InternalUser user, Post post) {
		this.startingDate = startingDate;
		this.endingDate = endingDate;
		this.user = user;
		this.post = post;
	}
	
}
