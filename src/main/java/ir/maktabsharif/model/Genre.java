package ir.maktabsharif.model;

import ir.maktabsharif.model.enums.Category;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@Table(name = "genres")
public class Genre extends BaseModel{
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Book> books;
}
