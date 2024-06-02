package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Prenotazioni")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_prenotazione")
    private int idBooking;

    @Column(name ="data_inizio")
    @Temporal(TemporalType.DATE)
    private Date startBooking;

    @Column(name ="data_fine")
    @Temporal(TemporalType.DATE)
    private Date endBooking;

    @Column(name ="luogo_ritiro")
    private String place_retreat;

    @Column(name ="luogo_riconsegna")
    private String delivery_place;

    @Column(name ="costo_totale")
    private int totalCost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_utente")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_mezzo")
    private Car car;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_tariffa")
    private Tariff tariff;
}
