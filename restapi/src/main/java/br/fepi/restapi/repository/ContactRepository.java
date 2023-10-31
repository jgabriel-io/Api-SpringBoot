package br.fepi.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fepi.restapi.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
