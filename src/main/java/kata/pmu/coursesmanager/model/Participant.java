package kata.pmu.coursesmanager.model;

public record Participant(String nom, Integer numero) {

    @Override
    public String toString() {
        return "Participant{" +
                "nom='" + nom + '\'' +
                ", numero=" + numero +
                '}';
    }
}
