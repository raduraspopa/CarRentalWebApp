package com.rrn.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name = "client_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int client_id;

	@Column(name = "client_cnp")
	private String client_cnp;

	@Column(name = "client_username")
	private String client_username;

	@Column(name = "client_pass")
	private String client_pass;

	@Column(name = "client_firstName")
	private String client_firstName;

	@Column(name = "client_lastName")
	private String client_lastName;

	@Column(name = "client_phone")
	private String client_phone;
	
	
	public int getClientId() {
		return client_id;
	}

	public String getClientCnp() {
		return client_cnp;
	}

	public void setClientCnp(String client_cnp) {
		this.client_cnp = client_cnp;
	}

	public String getClientUserName() {
		return client_username;
	}

	public void setClientUserName(String client_username) {
		this.client_username = client_username;
	}

	public String getClientPassword() {
		return client_pass;
	}

	public void setClientPassword(String client_password) {
		this.client_pass = client_password;
	}

	public String getClientFirstName() {
		return client_firstName;
	}

	public void setClientFirstName(String client_firstName) {
		this.client_firstName = client_firstName;
	}

	public String getClientLastName() {
		return client_lastName;
	}

	public void setClientLastName(String client_lastName) {
		this.client_lastName = client_lastName;
	}

	public String getClientPhone() {
		return client_phone;
	}

	public void setClientPhone(String client_phone) {
		this.client_phone = client_phone;
	}

}
