package CXM;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient")
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment(String appdate) {
        this.appdate = appdate;
    }
}
