package ch.hearc.gotit.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ch.hearc.gotit.constraints.validators.FieldEqualsConstraintValidator;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldEqualsConstraintValidator.class)
@Documented
public @interface FieldEqualsConstraint {

	public String message() default "Fields are not equals";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
	public String first();
	
	public String second();
	
	@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	public @interface List {
		FieldEqualsConstraint[] value();
	}
}
