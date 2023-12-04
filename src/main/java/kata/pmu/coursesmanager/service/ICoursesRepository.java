package kata.pmu.coursesmanager.service;

import kata.pmu.coursesmanager.model.Course;

public interface ICoursesRepository {

    Course save(Course course);
}
