package com.finshots.demo.model.dto;

import com.finshots.demo.model.PostingMedia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostingResponseDTO {

    private Long id;

    private String title;

    private String author;

    private Integer views;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static PostingResponseDTO entityToDto(PostingMedia postingMedia) {
        return PostingResponseDTO.builder()
                .id(postingMedia.getId())
                .author(postingMedia.getAuthor())
                .title(postingMedia.getTitle())
                .views(postingMedia.getViews())
                .createdAt(postingMedia.getCreatedAt())
                .updatedAt(postingMedia.getUpdatedAt())
                .build();
    }
}
