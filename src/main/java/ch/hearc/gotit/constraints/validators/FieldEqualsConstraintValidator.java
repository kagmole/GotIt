package ch.hearc.gotit.constraints.validators;

import ch.hearc.gotit.constraints.FieldEqualsConstraint;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldEqualsConstraintValidator implements ConstraintValidator<FieldEqualsConstraint, Object> {
	
	private String firstFieldName;
	private String secondFieldName;
	
	private String message;
	
	@Override
	public void initialize(FieldEqualsConstraint constraint) {
		firstFieldName = constraint.first();
		secondFieldName = constraint.second();
		
		message = constraint.message();
	}
	
	@Override
	public boolean isValid(Object target, ConstraintValidatorContext context) {
		
		boolean valid;
		
		try {
			Field firstField = target.getClass().getDeclaredField(firstFieldName);
			Field secondField = target.getClass().getDeclaredField(secondFieldName);
			
			firstField.setAccessible(true);
			secondField.setAccessible(true);
			
			Object firstObject = firstField.get(target);
			Object secondObject = secondField.get(target);
			
			valid = (firstObject == null && secondObject == null || firstObject != null && firstObject.equals(secondObject));
		} catch (Exception e) {
			valid = false;
		}
		
		if (!valid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message).addNode(firstFieldName).addConstraintViolation();
		}
		
		return valid;
	}
}
