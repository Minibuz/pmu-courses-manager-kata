package kata.pmu.coursesmanager.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record Course(Date date, String name, Integer numero, List<Participant> participants) {

    @Override
    public String toString() {
    return "Course{"
        + "date="
        + date
        + ", name='"
        + name
        + '\''
        + ", numero="
        + numero
        + ", participants="
        + participants.stream().map(Participant::toString).collect(Collectors.joining(",", "[", "]"))
        + '}';
    }
}
