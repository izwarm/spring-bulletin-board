package com.finshots.demo.repository;

import com.finshots.demo.model.PostingMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingMediaRepository extends JpaRepository<PostingMedia, Long> {

    List<PostingMedia> findByDeletedFalseOrderByCreatedAtDesc();

}
