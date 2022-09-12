package com.reyyencuneyt.enoca_challenge.Exception;

import java.text.MessageFormat;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(final Long employeeId){
        super(MessageFormat.format("Could not find employee with id: {0}", employeeId));
    }
}
