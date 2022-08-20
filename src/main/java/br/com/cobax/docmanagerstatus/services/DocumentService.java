package br.com.cobax.docmanagerstatus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cobax.docmanagerstatus.repositories.DocumentRepository;

@Service
public class DocumentService {
	
	@Autowired
	private DocumentRepository documentRepository;
	


}
