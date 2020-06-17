package guru.springframework.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@MappedSuperclass
public class Person extends BaseEntity{
    @NotBlank
    @Size(min = 3, max = 10)
    @Column(name="first_name")
    private String firstName;
    @NotBlank
    @Column(name="last_name")
    private String lastName;


}
