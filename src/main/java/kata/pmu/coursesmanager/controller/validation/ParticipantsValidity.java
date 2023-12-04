package kata.pmu.coursesmanager.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ParticipantsValidityValidator.class)
public @interface ParticipantsValidity {

    String message() default "The payload is heavier than the accepted max payload weight on the launcher";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
