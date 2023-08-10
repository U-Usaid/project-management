package com.projectmanagement.Controller;
import com.projectmanagement.Request.CardRequest;
import com.projectmanagement.Respones.CardResponse;
import com.projectmanagement.Respones.DeleteResponse;
import com.projectmanagement.Service.CardService;
import com.projectmanagement.model.Board;
import com.projectmanagement.model.Card;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/boards/{boardId}/cards")
public class CardController {
    CardService cardService;


    @PostMapping
        public ResponseEntity<CardResponse> addCardToBoard(@PathVariable Integer boardId, @RequestBody CardRequest cardRequest){
            Card card = cardRequest.convertToCard();
            card.setBoard(new Board(boardId));

            Card createdCard = cardService.createCard(card);

            CardResponse cardResponse = new CardResponse(
                    createdCard.getId(), createdCard.getTitle(), createdCard.getDescription(), createdCard.getSection()
            );

            return new ResponseEntity<>(cardResponse, HttpStatus.CREATED);
        }

    @GetMapping
        public ResponseEntity<List<CardResponse>> getCardBoard(@PathVariable Integer boardId){
            List<Card> cards = cardService.getAllCardBoard(boardId);
            List<CardResponse> cardResponses = new ArrayList<>();

            for (Card card : cards){
                CardResponse cardResponse =new CardResponse(
                        card.getId(), card.getTitle(), card.getDescription(), card.getSection()
                );

                cardResponses.add(cardResponse);
            }
            return new ResponseEntity<>(cardResponses, HttpStatus.OK);
        }


    @GetMapping("/{cardId}")
        public ResponseEntity<CardResponse> getGetCardBoardId(@PathVariable Integer boardId, @PathVariable Integer cardId){
            Card card = cardService.getCardBoardId(boardId, cardId);
            if (card == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            CardResponse cardResponse = new CardResponse(
                    card.getId(), card.getTitle(), card.getDescription(), card.getSection()
            );

            return new ResponseEntity<>(cardResponse, HttpStatus.OK);

        }



    @PostMapping("/{cardId}")
        public ResponseEntity<CardResponse> updateCardBoard(@PathVariable Integer boardId, @PathVariable Integer cardId, @RequestBody CardRequest updatedCardRequest){
            Card card = updatedCardRequest.convertToCard();
            card.setId(cardId);


            Card availableCard = cardService.getCardBoardId(boardId, cardId);
            if (availableCard == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }


            Card updatedCard = cardService.updateCard(card);
            if (updatedCard == null){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            CardResponse cardResponse = new CardResponse(
                    updatedCard.getId(), updatedCard.getTitle(), updatedCard.getDescription(), updatedCard.getSection()
            );

            return new ResponseEntity<>(cardResponse, HttpStatus.OK);




    }



    @DeleteMapping("/{cardId}")
        public ResponseEntity<DeleteResponse> deleteCardBoard(@PathVariable Integer boardId, @PathVariable Integer cardId){
        boolean cardDeleted = cardService.deleteCardBoard(boardId, cardId);
        if (!cardDeleted){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String message = "Card ID: " + cardId + "is deleted from board ID:" + boardId + "successfully.";
        DeleteResponse deleteResponse = new DeleteResponse(true, message);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }




}
