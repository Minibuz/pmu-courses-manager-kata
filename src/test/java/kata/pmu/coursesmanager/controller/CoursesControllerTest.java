package kata.pmu.coursesmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.controller.input.ParticipantEntry;
import kata.pmu.coursesmanager.controller.sender.ISender;
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
}