package com.projectmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Integer id;
    public String title;

    @Column(length = 1000)
    public String description;

    @Column(nullable = false)
    public int section;


    @ManyToOne
    @JoinColumn(name = "BoardId", nullable = false)
    public Board board;


    public String getSectionName(){
        return Board.getSectionName(this.section);
    }

}
