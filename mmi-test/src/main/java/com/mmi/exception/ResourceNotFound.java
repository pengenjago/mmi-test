package com.mmi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Object fieldValue;

    public ResourceNotFound( Object fieldValue) {
        super(String.format("Data Not Found With ID : %s", fieldValue));
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}