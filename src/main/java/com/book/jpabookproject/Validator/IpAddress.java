package com.book.jpabookproject.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.List;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IpAddressImpl.class})
public @interface IpAddress {
	
	String message() default "{validation.constraints.ip-address.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
