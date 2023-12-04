package kata.pmu.coursesmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.controller.input.ParticipantEntry;
import kata.pmu.coursesmanager.controller.sender.ISender;
import kata.pmu.coursesmanager.model.Course;
import kata.pmu.coursesmanager.model.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoursesController.class)
@DisplayName("Courses controller")
class CoursesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ICoursesService coursesService;

    @MockBean
    private IMapperCourseEntry mapperCourseEntry;

    @MockBean
    private ISender kafkaSender;

    @Test
    void newCourseTestSuccess() throws Exception {
        CourseEntry courseEntry = new CourseEntry(
                Date.from(Instant.now()),
                "name",
                List.of(
                        new ParticipantEntry("1", 1),
                        new ParticipantEntry("2", 2),
                        new ParticipantEntry("3", 3)));
        String json = objectMapper.writeValueAsString(courseEntry);

        mockMvc
                .perform(
                        post("/api/v1/courses")
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void newCourseTestErrorAmountOfParticipant() throws Exception {
        mockMvc
                .perform(
                        post("/api/v1/courses")
                                .content(
                                        objectMapper.writeValueAsString(
                                                new Course(
                                                        Date.from(Instant.now()),
                                                        "name",
                                                        1,
                                                        List.of(
                                                                new Participant("1", 1),
                                                                new Participant("2", 2)))))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void newCourseTestErrorParticipantNotWithGoodOrder() throws Exception {
        mockMvc
                .perform(
                        post("/api/v1/courses")
                                .content(
                                        objectMapper.writeValueAsString(
                                                new Course(
                                                        Date.from(Instant.now()),
                                                        "name",
                                                        1,
                                                        List.of(
                                                                new Participant("1", 1),
                                                                new Participant("2", 4),
                                                                new Participant("3", 5)))))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}