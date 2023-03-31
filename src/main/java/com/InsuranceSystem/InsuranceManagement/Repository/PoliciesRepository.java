package com.InsuranceSystem.InsuranceManagement.Repository;

import com.InsuranceSystem.InsuranceManagement.Models.Policies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliciesRepository extends JpaRepository<Policies,Integer>{

}
