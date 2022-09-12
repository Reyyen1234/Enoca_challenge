package com.reyyencuneyt.enoca_challenge.Dto;

import com.reyyencuneyt.enoca_challenge.Entity.Company;
import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import lombok.Data;


import java.util.List;
import java.util.stream.Collectors;

@Data
public class CompanyDto {
    private Long companyId;
    private String companyName;
    private List<Employee> employees;

    public static CompanyDto from(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setEmployees(company.getEmployees().stream().collect(Collectors.toList()));
        return companyDto;
    }

}
