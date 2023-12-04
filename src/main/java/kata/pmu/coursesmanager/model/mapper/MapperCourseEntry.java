package kata.pmu.coursesmanager.model.mapper;

import kata.pmu.coursesmanager.controller.IMapperCourseEntry;
import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.controller.input.ParticipantEntry;
import kata.pmu.coursesmanager.model.Course;
import kata.pmu.coursesmanager.model.Participant;
import org.springframework.stereotype.Component;

@Component
public class MapperCourseEntry implements IMapperCourseEntry {

    @Override
    public Course map(CourseEntry entry) {
        return new Course(
                entry.getDate(),
                entry.getName(),
                -1,
                entry.getParticipants().stream().map(this::participantMap)
                        .toList());
    }

    private Participant participantMap(ParticipantEntry entry) {
        return new Participant(entry.getName(), entry.getNumero());
    }
}
