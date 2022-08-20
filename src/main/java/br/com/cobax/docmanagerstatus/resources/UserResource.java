package br.com.cobax.docmanagerstatus.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cobax.docmanagerstatus.domain.dto.NewUserDTO;
import br.com.cobax.docmanagerstatus.domain.dto.ViewUserDTO;
import br.com.cobax.docmanagerstatus.services.UserService;

@RestController
@RequestMapping("users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Void> create(@Validated @RequestBody NewUserDTO newUserDTO){return userService.create(newUserDTO);}
	
	@GetMapping("{id}")
	public ResponseEntity<ViewUserDTO> findById(@PathVariable Long id){
		return userService.findById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<ViewUserDTO>> findById(){
		return userService.findAll();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Void> update(@RequestBody NewUserDTO newUserDTO, @PathVariable Long id){
		return userService.update(newUserDTO, id);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		return userService.delete(id);
	}

}
