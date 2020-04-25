package guru.springframework.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args)  {
        System.out.println("Adding pet types.......");
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        System.out.println("Loading owners.........");
        Owner o1 = new Owner();
        o1.setFirstName("Amol");
        o1.setLastName("G");
        o1.setAddress(" Mankhurd");
        o1.setCity("Mumbai");
        o1.setTelephone("9653362477");

        Pet pet = new Pet();
        pet.setType(savedDog);
        pet.setOwner(o1);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Romeo");
        o1.getPets().add(pet);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("Nikhil");
        o2.setLastName("S");
        o2.setAddress("Bandra");
        o2.setCity("Mumbai");
        o2.setTelephone("223663474");

        Pet pet2 = new Pet();
        pet2.setType(savedCat);
        pet2.setOwner(o2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Juliet");

        o2.getPets().add(pet2);
        ownerService.save(o2);

        Owner o3 = new Owner();
        o3.setFirstName("Amit");
        o3.setLastName("P");
       // o3.setId(3L);
        ownerService.save(o3);

        System.out.println("Loading vets.........");
        Vet v1 = new Vet();
       // v1.setId(1L);
        v1.setFirstName("Nishit");
        v1.setLastName("S");
        vetService.save(v1);

        Vet v2 = new Vet();
       // v2.setId(2L);
        v2.setFirstName("Vinod");
        v2.setLastName("S");
        vetService.save(v2);
    }
}
