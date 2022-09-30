package com.reyyencuneyt.enoca_challenge.Controller;

import com.reyyencuneyt.enoca_challenge.Dto.EmployeeDto;
import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import com.reyyencuneyt.enoca_challenge.Service.Impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value ="employees/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody final EmployeeDto employeeDto){
        Employee employee = employeeService.addEmployee(Employee.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }

    @GetMapping(value ="employees/list")
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        List<EmployeeDto> employeeDtos = employees.stream().map(EmployeeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping(value = "employees/find/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable final Long id){
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }

    @DeleteMapping(value = "employees/delete/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable final Long id){
        Employee employee = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }

    @PutMapping(value = "employees/edit/{id}")
    public ResponseEntity<EmployeeDto> editEmployee(@PathVariable final Long id,
                                            @RequestBody final EmployeeDto employeeDto){
        Employee editedEmployee = employeeService.editEmployee(id, Employee.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(editedEmployee), HttpStatus.OK);
    }
    @PutMapping(value = "employees/salarycal")
    public ResponseEntity<EmployeeDto> salaryCal(@RequestBody final EmployeeDto employeeDto){
        Employee employee = employeeService.salaryCal(Employee.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }
    @PutMapping(value = "employees/annualSalary")
    public ResponseEntity<EmployeeDto> annualSalary(@RequestBody final EmployeeDto employeeDto){
        Employee employee = employeeService.annualSalary(Employee.from(employeeDto));
        return new ResponseEntity<>(EmployeeDto.from(employee), HttpStatus.OK);
    }
}
