package com.iscod.coworkia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class InternalUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String firstname;

	@Email
	private String email;

	@Size(min = 8, message = "Le mot de passe doit contenir au moins {min} caractères.")
	private String password;
	
	//Un utilisateur ne peut avoir qu'un seul rôle
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", firstname=" + firstname + ", email=" + email + ", role=" + role + "]";
	}
	
	public InternalUser() {
	}

	public InternalUser(String name, String firstname, @Email String email,
			@Size(min = 8, message = "Le mot de passe doit contenir au moins {min} caractères.") String password,
			Role role) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
}
