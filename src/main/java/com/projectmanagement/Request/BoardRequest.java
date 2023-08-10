package com.projectmanagement.Request;

import com.projectmanagement.model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {
    public Integer id;
    public String title;


    public Map<Integer, String> columns;


    public Board ConvertToBoard() {
        Board board = new Board();

        board.setId(this.getId());
        board.setTitle(this.getTitle());
        board.setColumns(getColumns());
        return board;
    }

}
