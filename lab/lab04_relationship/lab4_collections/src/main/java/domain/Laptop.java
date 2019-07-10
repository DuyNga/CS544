package domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "laps")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @Override
    public String toString() {
        String t = String.format("{id: %s, name: %s, address: %s}",
                employee.getId(), employee.getName(), employee.getAddress());
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + t +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return Objects.equals(name, laptop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Laptop(String name) {
        this.name = name;
    }
}
