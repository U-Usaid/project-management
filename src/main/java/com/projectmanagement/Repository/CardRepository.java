package com.projectmanagement.Repository;

import com.projectmanagement.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository <Card, Integer> {
    List<Card> findBoardId(Integer boardId);
    Card findBoardCardId(Integer boardId, Integer cardId);
}
