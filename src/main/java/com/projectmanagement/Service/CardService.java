package com.projectmanagement.Service;
import com.projectmanagement.Repository.CardRepository;
import com.projectmanagement.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class   CardService {
    @Autowired
    private CardRepository cardRepository;


    public Card createCard(Card newCard){
        return cardRepository.save(newCard);
    }



    public List<Card> getAllCardBoard(Integer boardId){
        return cardRepository.findBoardId(boardId);
    }


    public Card getCardBoardId(Integer boardId, Integer cardId){
        return cardRepository.findBoardCardId(boardId, cardId);
    }



    public Card updateCard(Card updatingCard){
        Card availableCard = cardRepository.findById(updatingCard.getId()).orElse(null);
        if (availableCard == null){
            return null;
        }
        availableCard.setTitle(updatingCard.getTitle());
        availableCard.setDescription(updatingCard.getDescription());
        availableCard.setSection(updatingCard.getSection());
        return cardRepository.save(availableCard);
    }



    public boolean deleteCardBoard(Integer boardId, Integer cardId){
        Card card = cardRepository.findBoardCardId(boardId, cardId);
        if (card == null){
            return false;
        }
        cardRepository.delete(card);
        return true;
    }
















}
