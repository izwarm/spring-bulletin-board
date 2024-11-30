package com.finshots.demo.service;

import com.finshots.demo.model.PostingMedia;
import com.finshots.demo.model.dto.PostingMediaRequestDTO;

import java.util.List;

public interface PostingMediaService {

    List<PostingMedia> getAllPostingMedias();

    PostingMedia getPostingMediaById(Long id);

    PostingMedia createPostingMedia(PostingMediaRequestDTO request);

    PostingMedia updatePostingMedia(Long id, PostingMediaRequestDTO request, String password);

    void deletePostingMedia(Long id, String password);

    PostingMedia getViewsPostingMedia(Long id);
}
