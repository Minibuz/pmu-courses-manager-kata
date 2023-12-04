package kata.pmu.coursesmanager.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kata.pmu.coursesmanager.controller.input.CourseEntry;
import kata.pmu.coursesmanager.controller.input.ParticipantEntry;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ParticipantsValidityValidator implements ConstraintValidator<ParticipantsValidity, CourseEntry> {

    @Override
    public boolean isValid(CourseEntry value, ConstraintValidatorContext context) {
        var participants = new ArrayList<>(value.getParticipants());
        participants.sort(Comparator.comparingInt(ParticipantEntry::getNumero));
        return IntStream.of(participants.size() - 1)
                .allMatch(i -> participants.get(i).getNumero() == i+1);
    }
}
