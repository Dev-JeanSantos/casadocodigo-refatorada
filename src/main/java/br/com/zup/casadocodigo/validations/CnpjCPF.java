package br.com.zup.casadocodigo.validations;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;



public @interface CnpjCPF {
	@Constraint(validatedBy = {ValidaCnpjCPF.class})
	@Target({ElementType.FIELD, ElementType.PARAMETER})
	@Retention(value = RetentionPolicy.RUNTIME)
	@Documented
	public @interface CpfCnpj {

	    String message() default "CPF/CNPJ inváilido";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
	}
}
