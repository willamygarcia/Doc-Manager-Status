package br.com.cobax.docmanagerstatus.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cobax.docmanagerstatus.domain.User;
import br.com.cobax.docmanagerstatus.domain.dto.NewUserDTO;
import br.com.cobax.docmanagerstatus.domain.dto.ViewUserDTO;
import br.com.cobax.docmanagerstatus.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<Void> create(NewUserDTO newUserDTO){
		User user = newUserDTO.newUserDTOToUser(newUserDTO);
		user.setId(null);
		user = userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	public ResponseEntity<ViewUserDTO> findById(Long id){
		 ViewUserDTO viewUserDTO = new ViewUserDTO(userRepository.findById(id).get());
		 return ResponseEntity.ok().body(viewUserDTO);
	}
	
	public ResponseEntity<List<ViewUserDTO>> findAll(){
		
		List<User> listUser = userRepository.findAll();
		
		List<ViewUserDTO> lista = new ArrayList<>();
		lista = listUser.stream().map(ViewUserDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(lista);
	}
	
	public ResponseEntity<Void> update(NewUserDTO newUserDTO, Long id){
		newUserDTO.setId(id);
		userRepository.save(newUserDTO.newUserDTOToUser(newUserDTO));
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Void> delete(Long id){
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
