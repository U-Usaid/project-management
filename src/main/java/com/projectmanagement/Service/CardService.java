package com.projectmanagement.Service;
import com.projectmanagement.Repository.CardRepository;
import com.projectmanagement.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class   CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card createCard(@RequestBody Card newCard){
        return cardRepository.save(newCard);
    }








}
