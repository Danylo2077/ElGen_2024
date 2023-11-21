
package com.elgen.repository;


import com.elgen.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface MessageRepository extends JpaRepository<Message, String> {

        Message findByKey(String key);
        void deleteByKey(String key);
        boolean existsByKey(String key);

        List<Message> findAll();  // Отримати всі повідомлення
        long count();  // Підрахувати кількість повідомлень
        void delete(Message message);  // Видалити конкретне повідомлення
        void deleteAll();  // Видалити всі повідомлення

    }
