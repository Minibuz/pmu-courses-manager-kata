package kata.pmu.coursesmanager.controller.input;

import jakarta.validation.Valid;
import kata.pmu.coursesmanager.controller.validation.ParticipantsAmount;
import kata.pmu.coursesmanager.controller.validation.ParticipantsValidity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@ParticipantsAmount
@ParticipantsValidity
public class CourseEntry {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final Date date;
    private final String name;
    @Valid
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
