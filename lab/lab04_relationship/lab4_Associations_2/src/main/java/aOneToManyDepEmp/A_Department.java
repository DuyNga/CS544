package aOneToManyDepEmp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class A_Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private List<A_Employee> employees = new ArrayList<A_Employee>();

    public A_Department(String name) {
        this.name = name;
    }

    public void addEmployee(A_Employee employee){
        employees.add(employee);
        employee.setDepartment(this);
    }
}
