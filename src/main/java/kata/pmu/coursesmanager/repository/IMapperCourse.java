package kata.pmu.coursesmanager.repository;

import kata.pmu.coursesmanager.model.Course;
import kata.pmu.coursesmanager.repository.dao.CourseDao;

public interface IMapperCourse {

    CourseDao mapToDao(Course course);

    Course map(CourseDao courseDao);
}
