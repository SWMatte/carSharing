package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Abbonamenti")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_abbonamento")
    private int idSubscription;

    @Column(name ="tipo_abbonamento")
    @Enumerated(EnumType.STRING)
    private TypeSubscription typeSubscription;

    @Column(name ="costo_abbonamento")
    private int costSubscription;

    @Column(name ="descrizione")
    private String description;

    @ManyToMany(mappedBy = "subscription", fetch = FetchType.LAZY)
    private List<User> users;

    @Column(name ="delete_flag")
    private boolean deleteFlag;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Abbonamenti_Tariffe",
            joinColumns = @JoinColumn(name = "ID_abbonamento",referencedColumnName = "ID_abbonamento"),
            inverseJoinColumns = @JoinColumn(name ="ID_tariffa",referencedColumnName = "ID_tariffa"))
    private List<Tariff> tariffs;

}
