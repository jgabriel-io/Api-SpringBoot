package br.fepi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.restapi.model.Contact;
import br.fepi.restapi.repository.ContactRepository;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactRepository repository;
    
    @GetMapping
    public List<Contact> listAll(){
        return repository.findAll();
    }

    @PostMapping
    public Contact adicionar(@RequestBody Contact contact){
        return repository.save(contact);
    }

    @PutMapping
    public Contact alterar(@RequestBody Contact contact){
        if(contact.getId()>0)
            return repository.save(contact);
        return null;
    }

    public String deletar(@RequestBody Contact contact){
        if(contact.getId()>0){
            repository.delete(contact);
            return "Removido com sucesso";
        }
        return "Não encontrado";
    }
}
