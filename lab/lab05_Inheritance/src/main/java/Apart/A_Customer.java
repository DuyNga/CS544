package Apart;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class A_Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public A_Customer(String name) {
        this.name = name;
    }
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id")
    private List<A_Order> orders = new ArrayList<>();
}
