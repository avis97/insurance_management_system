package com.InsuranceSystem.InsuranceManagement.Repository;

import com.InsuranceSystem.InsuranceManagement.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClaimRepository extends JpaRepository<Claim,Integer>{
}
