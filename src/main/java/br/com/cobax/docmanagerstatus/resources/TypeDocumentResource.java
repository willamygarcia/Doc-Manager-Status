package br.com.cobax.docmanagerstatus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobax.docmanagerstatus.domain.TypeDocument;
import br.com.cobax.docmanagerstatus.services.TypeDocumentService;

@RestController
@RequestMapping("typedocuments")
public class TypeDocumentResource {

	@Autowired
	private TypeDocumentService typeDocumentService; 
	
	@PostMapping
	public ResponseEntity<Void> createDo(@RequestBody TypeDocument typeDocument){return typeDocumentService.create(typeDocument);}
	
	@GetMapping("{test}")
	public String test() {return "Ola Teste";}
	
	@GetMapping("{id}")
	public ResponseEntity<TypeDocument> findById(@PathVariable Long id){
		return typeDocumentService.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<TypeDocument>> findAll(){
		return typeDocumentService.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> update(@RequestBody TypeDocument typeDocument, @PathVariable Long id){
		return typeDocumentService.update(typeDocument, id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		return typeDocumentService.delete(id);
	}
}
