package com.projectmanagement.Request;

import com.projectmanagement.model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardRequest {
    public Integer id;
    public String title;
    public String description;

    public Integer section;

    public Card convertToCard(){
        Card card = new Card();
        card.setId(this.getId());
        card.setTitle((this.getTitle()));
        card.setDescription(this.getDescription());
        card.setSection(this.getSection());
        return card;
    }
}
