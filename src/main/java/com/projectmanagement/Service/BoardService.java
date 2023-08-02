package com.projectmanagement.Service;

import com.projectmanagement.Repository.BoardRepository;
import com.projectmanagement.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public Board createBoard(@RequestBody Board newBoard){
        return boardRepository.save(newBoard);
    }


    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    public Board getBoardId(Integer boardId){
        Board searchBoard = null;
        Optional<Board> availableBoard = boardRepository.findById(boardId);

        if (availableBoard.isPresent()){
            searchBoard = availableBoard.get();
        }
        return searchBoard;
    }

//    public Board updateBoard(@PathVariable(name ="id") Integer boardId, @RequestBody Board updatingBoard){
//        Board availableBoard = getBoardId(boardId);
//        availableBoard.title = updatingBoard.title;
//        return boardRepository.save(availableBoard);
//    }



    public Board deleteBoard(@PathVariable(name = "id") Integer id){
        Board availableBoard = getBoardId(id);

        if(availableBoard != null){
            boardRepository.delete(availableBoard);
        }
        return availableBoard;
    }
}
