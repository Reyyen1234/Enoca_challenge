package com.reyyencuneyt.enoca_challenge.Service.Impl;

import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import com.reyyencuneyt.enoca_challenge.Exception.EmployeeNotFoundException;
import com.reyyencuneyt.enoca_challenge.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployees(){
        return StreamSupport
                .stream(employeeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException(id));
    }

    public Employee deleteEmployee(Long id){
        Employee employee = getEmployee(id);
        employeeRepository.delete(employee);
        return employee;
    }

    @Transactional
    public Employee editEmployee(Long id, Employee employee){
        Employee employeeToEdit = getEmployee(id);
        employeeToEdit.setEmployeeName(employee.getEmployeeName());
        return employeeToEdit;
    }
}
