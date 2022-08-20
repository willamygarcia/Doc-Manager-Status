package br.com.cobax.docmanagerstatus.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.cobax.docmanagerstatus.enums.StatusDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Document implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String identificationDocument;
	
	private String nome;
	
	private String Descricao;
	
	private StatusDocument status;
	
	private LocalDate dateProdution =  LocalDate.now();
	
	private LocalDate dateChange;
	
	@OneToOne(cascade = CascadeType.ALL)
	private TypeDocument typeDocument;
	
	private LocalDate dataArquivamento;
	
	@ManyToOne
	private User user;
	
	@OneToOne
	private User userDestination;
	
}
