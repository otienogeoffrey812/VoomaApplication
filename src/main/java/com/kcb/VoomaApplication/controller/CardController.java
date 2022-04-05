package com.kcb.VoomaApplication.controller;

import com.kcb.VoomaApplication.model.Account;
import com.kcb.VoomaApplication.model.Card;
import com.kcb.VoomaApplication.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Card>> findAll(){
        return ResponseEntity.ok().body(cardService.findAll());
    }
    @GetMapping("/find/{cardId}")
    public ResponseEntity<Card> findCard(@PathVariable("cardId") Long cardId){
        return new ResponseEntity<Card>(cardService.findCard(cardId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Card createCard(@RequestBody Card card){
        return cardService.createCard(card);
    }

    @PutMapping("/update/{cardId}")
    public Card updateCard(@PathVariable("cardId") Long cardId,
                                 @RequestBody Card card) {
        return cardService.updateCard(cardId, card);
    }
}
