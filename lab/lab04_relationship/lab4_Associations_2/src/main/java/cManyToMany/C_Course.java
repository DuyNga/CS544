package cManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class C_Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public C_Course(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    List<C_Student> students = new ArrayList<>();

    @Override
    public String toString() {
        String t = "[";
        for (C_Student stu : students
        ) {
            t += String.format("{id: %s, name: %s}",
                   stu.getId(),stu.getName() );
        }
        t += "]";
        return "C_Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + t +
                '}';
    }
}
