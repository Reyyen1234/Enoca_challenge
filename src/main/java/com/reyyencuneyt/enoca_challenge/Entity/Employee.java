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

    private int employeeWorkingYear;

    @ManyToOne
    @JoinColumn(name = "ce_fk", referencedColumnName = "employeeId")
    private Company companies;

    public static Employee from(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeId(employeeDto.getEmployeeId());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setEmployeeWorkingYear(employeeDto.getEmployeeWorkingYear());
        return employee;
    }

    public Employee(int employeeAge, int employeeSalary, int employeeWorkingYear) {
        this.employeeAge = employeeAge;
        this.employeeSalary = employeeSalary;
        this.employeeWorkingYear = employeeWorkingYear;
    }
    public void annualSalary(){
        if((2022-this.employeeWorkingYear)>356){
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

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeSalary=" + employeeSalary +
                ", employeeWorkingYear=" + employeeWorkingYear +
                ", companies=" + companies +
                '}';
    }
}