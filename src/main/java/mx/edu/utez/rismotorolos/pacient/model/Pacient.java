package mx.edu.utez.rismotorolos.pacient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.rismotorolos.date.model.Date;
import mx.edu.utez.rismotorolos.queue.model.QueueModel;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pacient", indexes = {
        @Index(name = "pacient_name", columnList = "name"),
        @Index(name = "pacient_curp", columnList = "curp"),
        @Index(name = "pacient_social_number", columnList = "social_number_secure")
})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "last_name", columnDefinition = "VARCHAR(50)", nullable = true)
    private String lastName;

    @Column(name = "curp", columnDefinition = "VARCHAR(18)", nullable = false, unique = true)
    private String curp;

    @Column(name = "social_number_secure", columnDefinition = "SMALLINT", nullable = false, unique = true)
    private long socialNumberSecure;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(10)", nullable = false)
    private long phoneNumber;

    @Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = true, unique = true)
    private String email;

    @OneToMany(mappedBy = "pacient")
    @JsonIgnore
    private List<Date> dates;

    @ManyToOne
    @JoinColumn(name = "queue", columnDefinition = "TINYINT")
    private QueueModel queueModel;

    public Pacient(String name, String lastName, String curp, long socialNumberSecure, long phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.curp = curp;
        this.socialNumberSecure = socialNumberSecure;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
