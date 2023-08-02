package com.projectmanagement.Controller;

import com.projectmanagement.Service.BoardService;
import com.projectmanagement.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    BoardService boardService;


   @PostMapping
    public Board createBoard(@RequestBody Board newBoard){
       return boardService.createBoard(newBoard);
   }


   @GetMapping
    public List<Board> getAllBoards(){
       return  boardService.getAllBoards();
   }


   @GetMapping(path = "{id}")
    public Board getBoardId(@PathVariable(name = "id") Integer id){
       return boardService.getBoardId(id);
    }


//    @PutMapping(path = "{id}")
//    public Board updateBoard(@PathVariable(name = "id") Integer id, @RequestBody Board updatingBoard){
//       return boardService.updateBoard(id, updatingBoard);
//    }


    @DeleteMapping(path = "{id}")
    public Board deleteBoard(@PathVariable(name = "id") Integer id){
       return boardService.deleteBoard(id);
    }




}
