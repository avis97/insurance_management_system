package com.InsuranceSystem.InsuranceManagement.Models;

import java.util.*;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientId;
    @NotNull
    private String clientName;
    private String phoneNumber;
    @Column(unique = true)
    @NotNull
    private String clientEmail;
    @NotNull
    private String clientDob;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    List<Policies> policiesList=new ArrayList<>();
}
