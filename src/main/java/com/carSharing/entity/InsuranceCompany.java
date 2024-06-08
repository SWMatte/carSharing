package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Assicurazione")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_assicurazione")
    private int idInsuranceCompany;

    @Column(name = "nome_compagnia")
    private String nameInsurance;

    @Column(name = "numero_polizza")
    private String numberInsurance;

    @Column(name = "data_inizio")
    @Temporal(TemporalType.DATE)
    private Date insuranceStart;

    @Column(name = "data_scadenza")
    @Temporal(TemporalType.DATE)
    private Date insuranceEnd;

    @Column(name = "tipo_copertura")
    @Enumerated(EnumType.STRING)
    private TypeInsurance typeInsurance;

    @Column(name = "premio")
    private int awardInsurance;

    @Column(name = "contatto_emergenza")
    private String emergencyContact;

    @Column(name = "note_aggiuntive")
    private String note;

    @Column(name ="delete_flag")
    private boolean deleteFlag;
}
