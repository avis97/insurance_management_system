package com.InsuranceSystem.InsuranceManagement.Models;

import com.InsuranceSystem.InsuranceManagement.Enum.PoliciesType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Policies{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PoliciesId;
    @Column(unique = true)
    @NotNull
    private String number;
    @Enumerated(EnumType.STRING)
    private PoliciesType policiesType;
    private int policiesAmount;
    @CreationTimestamp
    private Date startDate;
    private String endDate;
    private int policiesTiming;
    @ManyToOne
    @JoinColumn
    Client client;
    @OneToMany(mappedBy = "policies",cascade = CascadeType.ALL)
    List<Claim> claimList=new ArrayList<>();
}
