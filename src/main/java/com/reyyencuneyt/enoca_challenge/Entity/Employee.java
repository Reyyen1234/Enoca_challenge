package com.reyyencuneyt.enoca_challenge.Entity;

import com.reyyencuneyt.enoca_challenge.Dto.EmployeeDto;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "Employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_age")
    private int employeeAge;

    @Column(name = "employee_salary")
    private int employeeSalary;

    @Column(name = "employee_workingYear")
    @DateTimeFormat(pattern = "yyyy")
    private Date employeeWorkingYear;

    @ManyToOne
    @JoinColumn(name = "ce_fk", referencedColumnName = "employeeId")
    private Company companies;

    public static Employee from(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        return employee;
    }



}