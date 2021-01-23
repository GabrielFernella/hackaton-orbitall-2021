package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
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

    public List<Card> getAllCards(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc(sortBy)));

        Page<Card> pagedResult = cardRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Card>();
        }
    }
}
