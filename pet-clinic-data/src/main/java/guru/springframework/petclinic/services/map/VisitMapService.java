package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.Visit;
import guru.springframework.petclinic.repositories.VisitRepository;
import guru.springframework.petclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    //private final VisitRepository visitRepository;

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null ||
            visit.getPet().getId() == null || visit.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
