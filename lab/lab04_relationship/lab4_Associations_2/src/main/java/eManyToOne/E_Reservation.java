package eManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class E_Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    private E_Book book;

    public E_Reservation(LocalDate date) {
        this.date = date;
    }
}
