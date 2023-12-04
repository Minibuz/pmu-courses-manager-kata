package kata.pmu.coursesmanager.repository.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "PARTICIPANT")
public class ParticipantDao {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "NUMERO")
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "COURSE")
    private CourseDao course;

    public ParticipantDao(String nom, Integer numero) {
        this(null, nom, numero);
    }

    public ParticipantDao(Integer id, String nom, Integer numero) {
        this.id = id;
        this.nom = nom;
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public Integer getNumero() {
        return numero;
    }
}
