package com.reyyencuneyt.enoca_challenge.Repository;

import com.reyyencuneyt.enoca_challenge.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
}
