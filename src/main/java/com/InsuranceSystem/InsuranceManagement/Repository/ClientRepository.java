package com.InsuranceSystem.InsuranceManagement.Repository;

import com.InsuranceSystem.InsuranceManagement.Models.Client;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{
}
