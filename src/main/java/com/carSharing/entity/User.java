package com.carSharing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Utenti")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID_utente" )
    private int idUser;

    @Column(name ="nome" )
    private String name;

    @Column(name ="cognome")
    private String lastName;

    private String email;

    private String password;

    @Column(name ="numero_telefono")
    private String phoneNumber;

    @Column(name ="indirizzo")
    private String address;

    @Column(name ="stato_attivazione_utente")
    private boolean userActive;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Utenti_Abbonamenti",
            joinColumns = @JoinColumn(name = "ID_utente",referencedColumnName = "ID_utente"),
            inverseJoinColumns = @JoinColumn(name ="ID_abbonamento",referencedColumnName = "ID_abbonamento"))
    private List<Subscription> subscription;

}
