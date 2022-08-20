package br.com.cobax.docmanagerstatus.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.cobax.docmanagerstatus.domain.Document;
import br.com.cobax.docmanagerstatus.domain.User;


public class ViewUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String username;
	
	private String fullName;
	
	private String email; 
	
	private List<Document> documents = new ArrayList<>();
	
	public ViewUserDTO() {
	}
	
	public ViewUserDTO(Long id, String username, String fullName, String email) {
		super();
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.email = email;
	}

	public ViewUserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.fullName = user.getFullName();
		this.email = user.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
	

}
