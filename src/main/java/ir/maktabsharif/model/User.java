package ir.maktabsharif.model;

import ir.maktabsharif.model.enums.Gender;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "users")
public abstract class User extends BaseModel{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "national_code", unique = true)
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
