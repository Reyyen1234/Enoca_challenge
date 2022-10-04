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
    private List<EmployeeDto> employeesDto;

    public static CompanyDto from(Company company){
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setEmployeesDto(company.getEmployees().stream().map(EmployeeDto::from).collect(Collectors.toList()));

        return companyDto;
    }

}
