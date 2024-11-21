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
@SuperBuilder
@Table(name = "books")
public class Book extends BaseModel{
    private String title;
    @Column(unique = true)
    private String isbn;
    private String author;
    private String publisher;
    @Column(name = "number_of_pages")
    private Integer numberOfPages;
    @Temporal(TemporalType.DATE)
    @Column(name = "published_date")
    private Date publishedDate;

    @ManyToOne
    @JoinColumn(name = "fk_genre")
    private Genre genre;

}
