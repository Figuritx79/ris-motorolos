package mx.edu.utez.rismotorolos.date.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.rismotorolos.doctor.model.Doctor;
import mx.edu.utez.rismotorolos.pacient.model.Pacient;

@Entity
@Table(name = "date")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_pacient", columnDefinition = "TINYINT")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_doctor", columnDefinition = "TINYINT")
    private Doctor doctor;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP")
    private Timestamp dateTime;
}
