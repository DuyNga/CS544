package fManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class F_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private F_Office office;

    public F_Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String t = String.format("{id: %s, name: %s}",
                office.getId(),office.getName());
        return "F_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", office=" + t +
                '}';
    }
}
