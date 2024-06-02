package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Mezzi")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_mezzo")
    private int idCar;

    @Column(name = "targa")
    private String licensePlate;

    @Column(name = "modello")
    private String model;

    @Column(name = "marca")
    private String brand;

    @Column(name = "anno")
    private int year;

    @Column(name = "tipo_carburante")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "chilometraggio")
    private int mileage;

    @Column(name = "stato_mezzo")
    @Enumerated(EnumType.STRING)
    private StateCar stateCar;

    @Column(name = "ultima_manutenzione")
    @Temporal(TemporalType.DATE)
    private Date lastMaintenance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_azienda")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_assicurazione")
    private InsuranceCompany insuranceCompany;


}