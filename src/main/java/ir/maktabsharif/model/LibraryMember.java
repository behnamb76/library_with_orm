package ir.maktabsharif.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "library_members")
public class LibraryMember extends User{
    @Temporal(TemporalType.DATE)
    @Column(name = "membership_date")
    private Date membershipDate;

    @PrePersist
    protected void onCreate() {
        membershipDate = new Date();
    }

    @Override
    public String toString() {
        return "Library Member{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dob=" + getDob() +
                ", nationalCode='" + getNationalCode() + '\'' +
                ", gender=" + getGender() + '\'' +
                ", membershipDate=" + getMembershipDate() +
                '}';
    }
}
