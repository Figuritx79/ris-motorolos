package mx.edu.utez.rismotorolos.queue.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import mx.edu.utez.rismotorolos.pacient.model.Pacient;

@Entity
@Table(name = "queue")
public class QueueModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "queue_number", columnDefinition = "SMALLINT", insertable = false, updatable = false)
    private long queue_number;

    @OneToMany(mappedBy = "queue")
    @JsonIgnore
    private List<Pacient> pacients;
}
