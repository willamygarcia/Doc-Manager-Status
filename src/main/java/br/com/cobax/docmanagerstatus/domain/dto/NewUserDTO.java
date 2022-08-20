package br.com.cobax.docmanagerstatus.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.cobax.docmanagerstatus.domain.Document;
import br.com.cobax.docmanagerstatus.domain.User;

public class NewUserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message = "O Usuário não pode ser Vazio")
	@Size(min = 3, max = 20, message = "O nome de Usuário não pode ser menor que: {min} ou maior que: {max}")
	private String username;
	
	@NotNull(message = "A senha não pode ser Vazia")
	@Size(min = 6, message = "A senha deve ser maior que: {min} !!!")
	private String password;
	
	@NotNull(message = "O Usuário não pode ser Vazio")
	@Size(min = 3, max = 20, message = "O nome de Usuário não pode ser menor que: {min} ou maior que: {max}")
	private String fullName;
	
	@Email(message = "Email invaálido!!!")
	private String email; 
	
	private List<Document> documents = new ArrayList<>();
	
	public NewUserDTO() {
	}

	public NewUserDTO(User user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public void removePassword() {
		setPassword(null);
	}
	
	public static NewUserDTO userDTOView(User user) {
		NewUserDTO userDTOview = new NewUserDTO();
		userDTOview.setId(user.getId());
		userDTOview.setUsername(user.getUsername());
		userDTOview.setFullName(user.getFullName());
		userDTOview.setEmail(user.getEmail());
		return userDTOview;
	}
	
	public User newUserDTOToUser(NewUserDTO newUserDTO) {
		User user = new User(newUserDTO.getId(), newUserDTO.getUsername(), newUserDTO.getPassword(), newUserDTO.getFullName(), newUserDTO.getEmail());
		return user;
	}

}
