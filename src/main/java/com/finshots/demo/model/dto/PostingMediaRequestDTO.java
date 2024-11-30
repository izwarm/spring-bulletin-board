package com.finshots.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostingMediaRequestDTO {

    private String title;

    private String author;

    private String password;

    private String content;
}
