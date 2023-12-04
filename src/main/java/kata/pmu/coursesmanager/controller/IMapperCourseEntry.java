package kata.pmu.coursesmanager.controller;

import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.model.Course;

public interface IMapperCourseEntry {

    Course map(CourseEntry entry);
}
