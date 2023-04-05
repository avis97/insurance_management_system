package com.InsuranceSystem.InsuranceManagement.DTOs;
import com.InsuranceSystem.InsuranceManagement.Enum.PoliciesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliciesRequestDto{
    private String number;
    private PoliciesType policiesType;
    private int amount;
    private int monthly_installment;
    private String endDate;
    private int timing;
    private int clientId;
}
