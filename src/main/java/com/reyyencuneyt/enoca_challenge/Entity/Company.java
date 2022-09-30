package com.reyyencuneyt.enoca_challenge.Entity;

import com.reyyencuneyt.enoca_challenge.Dto.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
//      @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//      @JoinColumn(name = "employee_id_fk" , referencedColumnName = "company_id")
//      private List<Employee> employees;
     @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
     @JoinColumn(name = "company_id_fk" , referencedColumnName = "company_id")
     private List<Employee> employees;

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }
    public static Company from(CompanyDto companyDto){
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyId(company.getCompanyId());
        return company;
    }
}