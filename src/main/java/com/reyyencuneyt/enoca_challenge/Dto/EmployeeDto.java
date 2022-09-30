package com.reyyencuneyt.enoca_challenge.Dto;

import com.reyyencuneyt.enoca_challenge.Entity.Company;
import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class EmployeeDto {

    private Long employeeId;

    private String employeeName;

    private int employeeAge;

    private int employeeSalary;

    private int employeeWorkingYear;

    private Company companies;

    public static EmployeeDto from(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeAge(employee.getEmployeeAge());
        employeeDto.setEmployeeSalary(employee.getEmployeeSalary());
        employeeDto.setEmployeeWorkingYear(employee.getEmployeeWorkingYear());
        return employeeDto;
    }

}
