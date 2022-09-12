package com.reyyencuneyt.enoca_challenge.Repository;

import com.reyyencuneyt.enoca_challenge.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
}
