package kata.pmu.coursesmanager.controller.input;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CourseEntry {

    private final Date date;
    private final String name;
    private final List<ParticipantEntry> participants;

    public CourseEntry(Date date, String name, List<ParticipantEntry> participants) {
        this.date = date;
        this.name = name;
        this.participants = participants;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public List<ParticipantEntry> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
