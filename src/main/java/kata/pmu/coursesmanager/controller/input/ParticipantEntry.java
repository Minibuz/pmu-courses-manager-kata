package kata.pmu.coursesmanager.controller.input;

public class ParticipantEntry {

    private final String name;
    private final Integer numero;

    public ParticipantEntry(String name, Integer numero) {
        this.name = name;
        this.numero = numero;
    }

    public String getName() {
        return name;
    }

    public Integer getNumero() {
        return numero;
    }
}
