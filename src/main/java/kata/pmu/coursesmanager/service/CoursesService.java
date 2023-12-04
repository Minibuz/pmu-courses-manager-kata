package kata.pmu.coursesmanager.service;

import kata.pmu.coursesmanager.controller.ICoursesService;
import kata.pmu.coursesmanager.model.Course;
import org.springframework.stereotype.Service;

@Service
public class CoursesService implements ICoursesService {

    private final ICoursesRepository repository;

    public CoursesService(ICoursesRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course save(Course course) {
        return repository.save(course);
    }
}
