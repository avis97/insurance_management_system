package com.InsuranceSystem.InsuranceManagement.Models;

import com.InsuranceSystem.InsuranceManagement.Enum.ClaimStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimId;
    @NotNull
    private String claimNumber;
    private String claimDate;
    private String claimDetails;
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;
    @ManyToOne
    @JoinColumn
    Policies policies;
}
