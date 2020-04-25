package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.services.CrudService;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetService;
import guru.springframework.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getType() != null){
                        if(pet.getType().getId() == null){
                            pet.setType(petTypeService.save(pet.getType()));
                        }
                    }else{
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId() == null){
                        pet.setId(petService.save(pet).getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lName) {
        return null;
    }
}
