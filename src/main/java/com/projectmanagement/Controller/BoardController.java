package com.projectmanagement.Controller;

import com.projectmanagement.Respones.BoardResponse;
import com.projectmanagement.Respones.DeleteResponse;
import com.projectmanagement.Service.BoardService;
import com.projectmanagement.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/board")
public class BoardController {
    @Autowired
    BoardService boardService;


   @PostMapping
   public ResponseEntity<BoardResponse> createBoard(@RequestBody Board board) {
       Board createdBoard = boardService.createBoard(board);

       // Map the createdBoard attributes to a new BoardResponse object
       BoardResponse boardResponse = new BoardResponse(
               createdBoard.getId(), createdBoard.getTitle(), createdBoard.getColumns());

       return new ResponseEntity<>(boardResponse, HttpStatus.CREATED);
   }


   @GetMapping
    public List<Board> getAllBoards(){
       return  boardService.getAllBoards();
   }


   @GetMapping(path = "{boardId}")
    public Board getBoardId(@PathVariable(name = "id") Integer id){
       return boardService.getBoardId(id);
    }


//    @PutMapping(path = "{id}")
//    public Board updateBoard(@PathVariable(name = "id") Integer id, @RequestBody Board updatingBoard){
//       return boardService.updateBoard(id, updatingBoard);
//    }


    @DeleteMapping(path = "{boardId}")
    public ResponseEntity<DeleteResponse> deleteBoard(@PathVariable Integer boardId) {
        boolean isBoardDeleted = boardService.deleteBoard(boardId);
        if (!isBoardDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Board is deleted successfully, create the response object
        DeleteResponse response = new DeleteResponse(true, "Board with ID " + boardId + " has been deleted successfully.");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    }





