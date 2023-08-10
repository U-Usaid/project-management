package com.projectmanagement.Respones;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponse {

    public Integer id;
    public String title;

    public Map<Integer, String> columns;
}
