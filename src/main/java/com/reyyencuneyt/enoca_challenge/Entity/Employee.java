package com.reyyencuneyt.enoca_challenge.Entity;

import com.reyyencuneyt.enoca_challenge.Dto.EmployeeDto;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_age")
    private int employeeAge;

    @Column(name = "employee_salary")
    private int employeeSalary;


//    Date d=new Date();
//    int year=d.getYear();

    @Column(name = "employee_workingYear")
    private int employeeWorkingYear;

    @ManyToOne
    @JoinColumn(name = "companyId", insertable = false, updatable = false)
    private Company companies;

    public static Employee from(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeAge(employeeDto.getEmployeeAge());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setEmployeeWorkingYear(employeeDto.getEmployeeWorkingYear());
        return employee;
    }

//    public Employee(int employeeAge, int employeeSalary, int employeeWorkingYear) {
//        this.employeeAge = employeeAge;
//        this.employeeSalary = employeeSalary;
//        this.employeeWorkingYear = employeeWorkingYear;
//    }
    public void annualSalary(){
    if((2022-this.employeeWorkingYear)>365){
           this.employeeSalary=this.employeeSalary*10/100;
       }
    }
    public void bonus(){
        if(this.employeeAge>=20 && this.employeeAge<=25 ){
           this.employeeSalary = this.employeeSalary*10/100;
        } else if (this.employeeAge>=26 && this.employeeAge<=30) {
            this.employeeSalary=this.employeeSalary*8/100;
        } else if (this.employeeAge>=31 && employeeAge<=36) {
            this.employeeSalary=this.employeeSalary*5/100;
        }else {
            this.employeeSalary=this.employeeSalary*3/100;
        }
    }

}