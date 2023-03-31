package com.InsuranceSystem.InsuranceManagement.DTOs;
import com.InsuranceSystem.InsuranceManagement.Enum.PoliciesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliciesResponseDtoForAllDetails{
    private int clientId;
    private String number;
    private PoliciesType policiesType;
    private int policiesAmount;
    private Date startDate;
    private String endDate;
    private int policiesTiming;
}
