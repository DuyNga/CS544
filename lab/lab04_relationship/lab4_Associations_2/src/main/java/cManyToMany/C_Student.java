package cManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class C_Student {
    @Id
    private long id;
    private String name;
    @ManyToMany
    private List<C_Course> courses = new ArrayList<>();

    public C_Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        String t = "[";
        for (C_Course course : courses
        ) {
            t += String.format("{id: %s, name: %s}"
                    , course.getId(), course.getName());
        }
        t += "]";
        return "C_Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + t +
                '}';
    }
}
