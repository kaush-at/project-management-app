package com.kaush.pma.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.FIELD}) // in here we define whre our annotation going to be target ex/ class level, method level, on field
@Retention(RetentionPolicy.RUNTIME)  // retention annotation describe if the custom annotation should be available in byte code(going to use in runtime)
@Constraint(validatedBy = UniqueValidator.class) //UniqueValidator is the class contains our validation rules (validatedBy eken tama define karanne 
													//validation rule tiyena class ekaclass )
public @interface UniqueValue {
	
	String message() default "Unique Constraint violated";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
}
