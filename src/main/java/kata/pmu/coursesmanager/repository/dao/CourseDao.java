package kata.pmu.coursesmanager.repository.dao;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class CourseDao {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMERO")
    private Integer numero = 1;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<ParticipantDao> participants;

    public CourseDao(Date date, String name, Integer numero, List<ParticipantDao> participants) {
        this(null, date, name, numero, participants);
    }

    public CourseDao(Integer id, Date date, String name, Integer numero, List<ParticipantDao> participants) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.numero = numero;
        this.participants = participants;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setParticipants(List<ParticipantDao> participants) {
        this.participants = participants;
    }

    public List<ParticipantDao> getParticipants() {
        return participants;
    }
}
