package com.reyyencuneyt.enoca_challenge.Controller;

import com.reyyencuneyt.enoca_challenge.Dto.CompanyDto;
import com.reyyencuneyt.enoca_challenge.Entity.Company;
import com.reyyencuneyt.enoca_challenge.Service.Impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody final CompanyDto companyDto){
        Company company = companyService.addCompany(Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getCompanies(){
        List<Company> companies = companyService.getCompany();
        List<CompanyDto> companyDtos = companies.stream().map(CompanyDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(companyDtos, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable final Long id){
        Company company = companyService.getCompany(id);
        return new ResponseEntity<>(CompanyDto.from(company ), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CompanyDto> deleteCompany(@PathVariable final Long id){
        Company company = companyService.deleteCompany(id);
        return new ResponseEntity<>(CompanyDto.from(company ), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CompanyDto> editCompany(@PathVariable final Long id,
                                            @RequestBody final CompanyDto companyDto){
        Company company = companyService.editCompany(id, Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }

    @PostMapping(value = "{cartId}/items/{itemId}/add")
    public ResponseEntity<CompanyDto> addEmployeeToCompany(@PathVariable final Long companyId,
                                                 @PathVariable final Long employeeId){
        Company company = companyService.addEmployeeToCompany(companyId, employeeId);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }

    @DeleteMapping(value = "{cartId}/items/{itemId}/remove")
    public ResponseEntity<CompanyDto> removeEmployeeFromCompany(@PathVariable final Long companyId,
                                                      @PathVariable final Long employeeId){
        Company company = companyService.removeEmployeeFromCompany(companyId, employeeId);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }

}
