package ir.maktabsharif.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "librarians")
public class Librarian extends User{
    @Override
    public String toString() {
        return "Librarian{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dob=" + getDob() +
                ", nationalCode='" + getNationalCode() + '\'' +
                ", gender=" + getGender() +
                '}';
    }
}
