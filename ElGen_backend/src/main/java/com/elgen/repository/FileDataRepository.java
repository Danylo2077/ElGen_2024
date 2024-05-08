package com.elgen.repository;

import java.util.Optional;

import com.elgen.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long>{
    Optional<FileData> findByName(String fileName);

}