package com.projectmanagement.Respones;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteResponse {
    public boolean successful;
    public String message;

}
