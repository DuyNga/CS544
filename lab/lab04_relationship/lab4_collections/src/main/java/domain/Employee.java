package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "emps")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpId")
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Set<Laptop> laptops = new HashSet<>();

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
        laptop.setEmployee(this);
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
