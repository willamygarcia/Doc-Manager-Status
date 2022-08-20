package br.com.cobax.docmanagerstatus.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cobax.docmanagerstatus.domain.TypeDocument;
import br.com.cobax.docmanagerstatus.repositories.TypeDocumentRepository;

@Service
public class TypeDocumentService {
	
	@Autowired
	private TypeDocumentRepository typeDocumentRepository;
	
	public ResponseEntity<Void> create(TypeDocument typeDocument){
		typeDocument.setId(null);
		typeDocument = typeDocumentRepository.save(typeDocument);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(typeDocument.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public ResponseEntity<TypeDocument> findById(Long id){
		Optional<TypeDocument> typeDocumentOptional = typeDocumentRepository.findById(id);
		return ResponseEntity.ok().body(typeDocumentOptional.get());
	}
	
	public ResponseEntity<List<TypeDocument>> findAll(){
		return ResponseEntity.ok().body(typeDocumentRepository.findAll());
	}
	
	public ResponseEntity<Void> update(TypeDocument typeDocument, Long id){
		typeDocument.setId(id);
		typeDocumentRepository.save(typeDocument);
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Void> delete(Long id){
		typeDocumentRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
