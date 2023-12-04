package kata.pmu.coursesmanager.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kata.pmu.coursesmanager.controller.input.CourseEntry;

public class ParticipantsAmountValidator implements ConstraintValidator<ParticipantsAmount, CourseEntry> {

    @Override
    public boolean isValid(CourseEntry value, ConstraintValidatorContext context) {
        return value.getParticipants().size() >= 3;
    }
}
