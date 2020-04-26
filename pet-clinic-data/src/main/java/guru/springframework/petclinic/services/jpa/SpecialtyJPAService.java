package guru.springframework.petclinic.services.jpa;

import guru.springframework.petclinic.model.Speciality;
import guru.springframework.petclinic.repositories.SpecialtiesRepository;
import guru.springframework.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialtyJPAService implements SpecialtyService {
    private final SpecialtiesRepository specialtiesRepository;

    public SpecialtyJPAService(SpecialtiesRepository specialtiesRepository) {
        this.specialtiesRepository = specialtiesRepository;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialtiesRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return specialtiesRepository.save(object);
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtiesRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public void delete(Speciality object) {
        specialtiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtiesRepository.deleteById(aLong);
    }
}
