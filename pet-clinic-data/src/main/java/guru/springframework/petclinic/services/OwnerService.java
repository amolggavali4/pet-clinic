package guru.springframework.petclinic.services;

import guru.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lName);
    Owner findById(Long id);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
