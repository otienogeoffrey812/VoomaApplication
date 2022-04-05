package com.kcb.VoomaApplication.service;

import com.kcb.VoomaApplication.Exceptions.NotFoundException;
import com.kcb.VoomaApplication.model.Card;
import com.kcb.VoomaApplication.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private  final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    public List<Card> findAll() {
        return cardRepository.findAll();
    }


    public Card findCard(Long cardId) {
        return cardRepository.findById(cardId)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    "Card with id '" + cardId + "' doesn't exist!");
                            return notFoundException;
                        });

    }

    public Card createCard(Card card){
        if (!cardRepository.findById(card.getCardId()).isPresent()){
            throw new NotFoundException("Card with id '"+card.getCardId()+"' doesn't exist!");
        }
        return cardRepository.save(card);
    }

    public Card updateCard(Long cardId, Card card) {

        Card fetchedCard = cardRepository.findById(cardId).orElseThrow(
                () -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "Card with id '" + cardId + "' doesn't exist");
                    return notFoundException;
                });

        fetchedCard.setCardAlias(card.getCardAlias());
        return cardRepository.save(fetchedCard);
    }
}
