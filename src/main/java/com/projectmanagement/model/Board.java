package com.projectmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String title;

    @ElementCollection
    @CollectionTable(name = "boardColumns", joinColumns = @JoinColumn(name = "boardId"))
    @MapKeyColumn(name = "columnIndex")
    @Column(name = "columnName")
    public Map<Integer, String> columns = Map.of(
            1, "To do",
            2, "In progress",
            3, "Done"
    );

    public Board(Integer id){
        this.id = id;
    }

    public Board(String title, Map<Integer, String> columns){
        this.title = title;
        this.columns = columns;
    }

    public static String getSectionName(int sectionIndex){
        switch (sectionIndex){
            case 1:
                return "To Do";
            case 2:
                return "In Progress";
            case 3:
                return "done";
            default:
                return "ERROR";
        }
    }

}
