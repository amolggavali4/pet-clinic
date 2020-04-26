package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface SpecialtiesRepository extends CrudRepository<Speciality, Long> {
}
