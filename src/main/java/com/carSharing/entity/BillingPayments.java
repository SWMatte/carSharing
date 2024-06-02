package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Fatturazione_Pagamenti")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillingPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_fattura")
    private  int idBillingPayments;

    @Column(name ="importo_totale")
    private int totalBillingPayment;

    @Column(name ="data_fattura")
    @Temporal(TemporalType.DATE)
    private Date dateBillingPayment;

    @Column(name ="metodo_pagamento")
    @Enumerated(EnumType.STRING)
    private MethodPayment methodPayment;


    @Column(name ="stato_pagamento")
    @Enumerated(EnumType.STRING)
    private StatePayment statePayment;

    @Column(name ="pdf_fattura")
    private String pdf;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_prenotazione")
    private Booking booking;



}
