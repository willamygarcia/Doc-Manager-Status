package br.com.cobax.docmanagerstatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cobax.docmanagerstatus.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
