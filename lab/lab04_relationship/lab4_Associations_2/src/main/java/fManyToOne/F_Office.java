package fManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class F_Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public F_Office(String name) {
        this.name = name;
    }
    @OneToMany(mappedBy = "office")
    private List<F_Employee> employees = new ArrayList<>();
}
