package com.reyyencuneyt.enoca_challenge.Exception;

import java.text.MessageFormat;

public class EmployeeIsAlreadyAssignedException extends RuntimeException{
    public EmployeeIsAlreadyAssignedException(final Long employeeId, final Long companyId){
        super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", employeeId, companyId));
    }
}
