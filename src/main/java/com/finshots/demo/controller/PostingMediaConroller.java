package com.finshots.demo.controller;

import com.finshots.demo.model.dto.PostingMediaRequestDTO;
import com.finshots.demo.model.dto.PostingResponseDTO;
import com.finshots.demo.service.PostingMediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/posting-media")
@RequiredArgsConstructor
public class PostingMediaConroller {

    private final PostingMediaService postingMediaService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<PostingResponseDTO> getAllPostingMedia() {
        return postingMediaService.getAllPostingMedias().stream()
                .map(PostingResponseDTO::entityToDto)
                .toList();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public PostingResponseDTO getPostingMedia(@PathVariable Long id) {
        return PostingResponseDTO.entityToDto(postingMediaService.getPostingMediaById(id));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public PostingResponseDTO createPostingMedia(@RequestBody PostingMediaRequestDTO request) {
        return PostingResponseDTO.entityToDto(postingMediaService.createPostingMedia(request));
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public PostingResponseDTO updatePostingMedia(@PathVariable Long id, @RequestBody PostingMediaRequestDTO request, @RequestParam String password) {
        return PostingResponseDTO.entityToDto(postingMediaService.updatePostingMedia(id, request, password));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deletePostingMedia(@PathVariable Long id, @RequestParam String password) {
        postingMediaService.deletePostingMedia(id, password);
    }

    @GetMapping("/views/{id}")
    public PostingResponseDTO getViewsPostingMedia(@PathVariable String id){
        return PostingResponseDTO.entityToDto(postingMediaService.getViewsPostingMedia(Long.parseLong(id)));
    }
}
