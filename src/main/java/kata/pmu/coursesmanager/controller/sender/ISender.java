package kata.pmu.coursesmanager.controller.sender;

import kata.pmu.coursesmanager.model.Course;

public interface ISender {

    void send(Course course) throws Exception;
}
