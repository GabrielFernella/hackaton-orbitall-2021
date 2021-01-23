package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardService {
    private CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save((card));
    }

    public Object updateCard(Long id, Card card) {

        Object response = cardRepository.findById(id)
                .map( cards -> {
                    cards.setCardNumber(card.getCardNumber());
                    cards.setEmbossName(card.getEmbossName());
                    cards.setCustomerName(card.getCustomerName());
                    cards.setDocumentNumber(card.getDocumentNumber());
                    cards.setMotherName(card.getMotherName());
                    cards.setAddress(card.getAddress());
                    cards.setCity(card.getCity());

                    return card;
                });

        return response;
    }

    public List<Card> findAll() {
        List<Card> customers = new ArrayList<>();
        cardRepository.findAll().forEach(customers :: add);

        return customers;
    }

    public Object findById(Long id){
        return cardRepository.findById(id);
    }

    public Object deleteCard(Long id){

        Object available =  cardRepository.findById(id).map(user -> {
            cardRepository.deleteById(id);
            return user;
        });

        return available;
    }
}
