package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Manutenzione")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_manutenzione")
    private int idMaintenance;

    @Column(name ="data_manutenzione")
    @Temporal(TemporalType.DATE)
    private Date dateMaintenance;

    @Column(name ="tipo_manutenzione")
    private String typeMaintenance;

    @Column(name ="costo")
    private  int costMaintenance;

    @Column(name ="note")
    private String note;


    @ManyToOne()
    @JoinColumn(name = "ID_azienda")
    private Company company;


    @ManyToOne()
    @JoinColumn(name = "ID_mezzo")
    private Car car;

    @Column(name ="delete_flag")
    private boolean deleteFlag;

}
