package com.finshots.demo.service;

import com.finshots.demo.model.PostingMedia;
import com.finshots.demo.model.dto.PostingMediaRequestDTO;
import com.finshots.demo.repository.PostingMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostingMediaServiceImpl implements PostingMediaService {

    private final PostingMediaRepository postingMediaRepository;

    public List<PostingMedia> getAllPostingMedias() {
        return postingMediaRepository.findByDeletedFalseOrderByCreatedAtDesc();
    }

    public PostingMedia getPostingMediaById(Long id) {
        return postingMediaRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public PostingMedia createPostingMedia(PostingMediaRequestDTO request) {
        PostingMedia postingMedia = new PostingMedia();
        postingMedia.setTitle(request.getTitle());
        postingMedia.setAuthor(request.getAuthor());
        postingMedia.setPassword(request.getPassword());
        postingMedia.setContent(request.getContent());
        postingMedia.setCreatedAt(LocalDateTime.now());
        return postingMediaRepository.save(postingMedia);
    }

    public PostingMedia updatePostingMedia(Long id, PostingMediaRequestDTO request, String password) {
        PostingMedia postingMedia = getPostingMediaById(id);
        if (!postingMedia.getPassword().equals(password)) throw new RuntimeException("Password does not match");
        postingMedia.setTitle(request.getTitle());
        postingMedia.setContent(request.getContent());
        postingMedia.setUpdatedAt(LocalDateTime.now());
        return postingMediaRepository.save(postingMedia);
    }

    public void deletePostingMedia(Long id, String password) {
        PostingMedia postingMedia = getPostingMediaById(id);
        if (!postingMedia.getPassword().equals(password)) throw new RuntimeException("Password does not match");
        postingMedia.setDeleted(true);
        postingMediaRepository.save(postingMedia);
    }

    @Override
    public PostingMedia getViewsPostingMedia(Long id) {
        Optional<PostingMedia> optionalPostingMedia = postingMediaRepository.findById(id);
        if (optionalPostingMedia.isPresent()) {
            PostingMedia postingMedia = optionalPostingMedia.get();
            postingMedia.setViews(postingMedia.getViews() + 1);
            postingMediaRepository.save(postingMedia);
            return postingMedia;
        }
        return null;
    }

}
