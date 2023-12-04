package kata.pmu.coursesmanager.repository;

import kata.pmu.coursesmanager.model.Course;
import kata.pmu.coursesmanager.repository.dao.CourseDao;
import kata.pmu.coursesmanager.service.ICoursesRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CoursesRepository implements ICoursesRepository {

    private final IMapperCourse mapperCourse;
    private final CoursesDaoRepository coursesRepository;

    public CoursesRepository(
            IMapperCourse mapperCourse,
            CoursesDaoRepository coursesRepository) {
        this.mapperCourse = mapperCourse;
        this.coursesRepository = coursesRepository;
    }

    @Override
    public Course save(Course course) {
        CourseDao dao = mapperCourse.mapToDao(course);
        Integer numero = coursesRepository.getLastNumberForDay(course.date());
        if ( numero == null ) {
            numero = 0;
        }
        dao.setNumero(numero + 1);
        return mapperCourse.map(coursesRepository.save(dao));
    }
}
