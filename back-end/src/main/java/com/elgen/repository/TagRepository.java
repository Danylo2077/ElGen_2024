package com.elgen.repository;

import com.elgen.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Override
    List<Tag> findAll();
    List<Tag> findTagByTag_id(Long tag_id);
    List<Tag> findTagByTag_name(String tag_id);
    Tag save(Tag tag);
    void delete(Tag tag);
}
