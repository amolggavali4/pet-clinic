package guru.springframework.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.map.OwnerServiceMap;
import guru.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args)  {
        System.out.println("Loading owners.........");
        Owner o1 = new Owner();
        o1.setFirstName("Amol");
        o1.setLastName("G");
        o1.setId(1L);
        ownerService.save(1L, o1);

        Owner o2 = new Owner();
        o2.setFirstName("Nikhil");
        o2.setLastName("S");
        o2.setId(2L);
        ownerService.save(2L, o2);

        Owner o3 = new Owner();
        o3.setFirstName("Amit");
        o3.setLastName("P");
        o3.setId(3L);
        ownerService.save(3L, o3);

        System.out.println("Loading vets.........");
        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Nishit");
        v1.setLastName("S");
        vetService.save(1L, v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("Vinod");
        v2.setLastName("S");
        vetService.save(2L, v2);
    }
}
