package com.reyyencuneyt.enoca_challenge.Service.Impl;

import com.reyyencuneyt.enoca_challenge.Entity.Company;
import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import com.reyyencuneyt.enoca_challenge.Exception.CompanyNotFoundException;
import com.reyyencuneyt.enoca_challenge.Repository.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CompanyService  {

    private final ICompanyRepository companyRepository;
    private final EmployeeService employeeService;

    @Autowired
    public CompanyService(ICompanyRepository companyRepository, EmployeeService employeeService) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getCompany(){
        return StreamSupport
                .stream(companyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Company getCompany(Long id){
        return companyRepository.findById(id).orElseThrow(() ->
                new CompanyNotFoundException(id));
    }

    public Company deleteCompany(Long id){
        Company cart = getCompany(id);
        companyRepository.delete(cart);
        return cart;
    }

    @Transactional
    public Company editCompany(Long id, Company company){
        Company CompanyToEdit = getCompany(id);
        CompanyToEdit.setCompanyName(company.getCompanyName());
        return CompanyToEdit;
    }

    @Transactional
    public Company addEmployeeToCompany(Long companyId, Long employeeId){
        Company company = getCompany(companyId);
        Employee employee = employeeService.getEmployee(employeeId);
        company.addEmployee(employee);
        employee.setCompanies(company);
        return company;
    }

    @Transactional
    public Company removeEmployeeFromCompany(Long companyId, Long employeeId){
        Company company = getCompany(companyId);
        Employee employee = employeeService.getEmployee(employeeId);
        company.removeEmployee(employee);
        return company;
    }


}
