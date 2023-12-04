package kata.pmu.coursesmanager.controller.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kata.pmu.coursesmanager.model.Course;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender implements ISender {

    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final KafkaTemplate<Object, Object> template;

    public KafkaSender(KafkaTemplate<Object, Object> template) {
        this.template = template;
    }

    @Override
    public void send(Course course) throws JsonProcessingException {
        this.template.send("courses", objectMapper.writeValueAsString(course));
    }
}
