package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Aziende")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_azienda")
    private int idCompany;

    @Column(name ="nome")
    private String nameCompany;

    @Column(name ="indirizzo")
    private String address;

    @Column(name ="partita_IVA")
    private String VATNumber;

    @Column(name ="informazioni_contatto")
    private String companyInformation;

    @Column(name ="delete_flag")
    private boolean deleteFlag;
}
