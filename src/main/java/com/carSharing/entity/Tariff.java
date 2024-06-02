package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Tariffe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_tariffa")
    private int idTariff;

    @Column(name = "tipo_tariffa")
    @Enumerated(EnumType.STRING)
    private TypeTariff typeTariff;

    @Column(name = "costo")
    @Enumerated(EnumType.STRING)
    private Cost cost;

    @ManyToMany(mappedBy = "tariffs", fetch = FetchType.LAZY)
    private List<Subscription> subscriptions;
}
