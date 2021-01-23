package com.orbitallcorp.hack21.cards.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Number cardNumber;
    private String embossName;
    private String customerName;
    private String documentNumber;
    private String motherName;
    private String address ;
    private String city;
}
