package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
