package com.orbitallcorp.hack21.cards.controllers;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {

    @Autowired
    private CardService cardService;


    @GetMapping
    public ResponseEntity<List<Card>> findAll() {
        List<Card> card = cardService.findAll();
        return ResponseEntity.ok(card);
    }

    @GetMapping(path = {"/paginationAndSorting"})
    public ResponseEntity<List<Card>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize,
            @RequestParam(defaultValue = "cardNumber") String sortBy)
    {
        List<Card> list = cardService.getAllCards(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Card>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> findOne(@PathVariable("id") Long id) {
        try {
            Card card = (Card) cardService.findById(id);
            return ResponseEntity.ok((card));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Card> save(@RequestBody Card card) {
        Card savedCustomer = cardService.save((card));

        return new ResponseEntity(savedCustomer, HttpStatus.CREATED);
    }


    @PutMapping("/cards/{id}")
    public ResponseEntity<Card> update(@RequestBody Card card, @PathVariable("id") Long id) {
        try {
            Card newCard = (Card) cardService.updateCard(id,card);
            return ResponseEntity.ok((newCard));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Card> delete(@PathVariable("id") Long id) {
        try {
            Card deletedCard = (Card) cardService.deleteCard(id);
            return ResponseEntity.ok((deletedCard));

        }catch (Error err) {
            return ResponseEntity.notFound().build();
        }
    }
}
