package domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name ="studentId")
    private Map<String,Student> studentMap = new HashMap<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(String key, Student student){
        studentMap.put(key,student);
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentMap=" + studentMap +
                '}';
    }
}
