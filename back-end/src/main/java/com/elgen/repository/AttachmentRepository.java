package com.elgen.repository;

import com.elgen.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Attachment save(Attachment attachment);
    void delete(Attachment attachment);
}
