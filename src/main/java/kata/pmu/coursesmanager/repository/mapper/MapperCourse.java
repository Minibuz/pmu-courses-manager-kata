package kata.pmu.coursesmanager.repository.mapper;

import kata.pmu.coursesmanager.model.Course;
import kata.pmu.coursesmanager.model.Participant;
import kata.pmu.coursesmanager.repository.IMapperCourse;
import kata.pmu.coursesmanager.repository.dao.CourseDao;
import kata.pmu.coursesmanager.repository.dao.ParticipantDao;
import org.springframework.stereotype.Component;

@Component
public class MapperCourse implements IMapperCourse {

    @Override
    public CourseDao mapToDao(Course course) {
        return new CourseDao(
                course.date(), course.name(), course.numero(),
                course.participants().stream().map(this::mapToDao).toList());
    }

    @Override
    public Course map(CourseDao courseDao) {
        return new Course(
                courseDao.getDate(), courseDao.getName(), courseDao.getNumero(),
                courseDao.getParticipants().stream().map(this::map).toList());
    }

    public ParticipantDao mapToDao(Participant participant) {
        return new ParticipantDao(participant.nom(), participant.numero());
    }

    public Participant map(ParticipantDao participantDao) {
        return new Participant(participantDao.getNom(), participantDao.getNumero());
    }
}
