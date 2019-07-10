package aOneToManyDepEmp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class A_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private A_Department department;

    public A_Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String t = String.format("{id: %s, name: %s}"
                , department.getId(), department.getName());
        return "A_Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + t +
                '}';
    }
}
