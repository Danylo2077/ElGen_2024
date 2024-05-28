package com.elgen.repository;

import java.util.Optional;

import com.elgen.model.FileData;
import com.elgen.model.Post;
import com.elgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{
    Optional<FileData> findByName(String fileName);

    FileData findByPost(Post post);

    <Optional>FileData findByUser(User user);


}