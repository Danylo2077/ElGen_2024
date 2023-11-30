
package com.elgen.repository;

import com.elgen.model.Message;
import com.elgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    //List<Message> findByName(String name);
    Optional<Message> findById (Long message_id);
    Message save(Message message);
    void delete(Message message);
    void deleteById(Long message_id);

}

