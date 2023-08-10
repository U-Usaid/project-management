package com.projectmanagement.Respones;

import com.projectmanagement.model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    public Integer id;
    public String title;
    public String description;

    public Integer section;


    public String getSectionName(){
        return Board.getSectionName(this.section);
    }


}
