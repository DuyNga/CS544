package dOneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class D_Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    public D_Reservation(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "D_Reservation{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
