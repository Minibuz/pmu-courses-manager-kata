package kata.pmu.coursesmanager.controller;

import jakarta.validation.Valid;
import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.controller.sender.ISender;
import kata.pmu.coursesmanager.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    private final static Logger logger = LoggerFactory.getLogger(CoursesController.class);
    private final ICoursesService coursesService;
    private final IMapperCourseEntry mapperCourseEntry;
    private final ISender kafkaSender;

    public CoursesController(
            ICoursesService coursesService,
            IMapperCourseEntry mapperCourseEntry, ISender kafkaSender) {
        this.coursesService = coursesService;
        this.mapperCourseEntry = mapperCourseEntry;
        this.kafkaSender = kafkaSender;
    }

    @PostMapping
    public Course newCourse(@RequestBody @Valid CourseEntry courseEntry) throws Exception {
        Course course = coursesService.save(mapperCourseEntry.map(courseEntry));
        kafkaSender.send(course);
        return course;
    }

    @KafkaListener(id = "courseListener", topics = "courses")
    public void listen(Course course) {
        logger.info("Received: " + course);
    }
}
