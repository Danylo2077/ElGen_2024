package com.elgen.repository;

import com.elgen.model.UserAccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountStatusRepository extends JpaRepository<UserAccountStatus, Long> {
    UserAccountStatus findByUserAccountStatusId(Long user_account_status_id);
    UserAccountStatus findByUserAccountStatusName(String user_account_status_name);
    void deleteByUser_account_status_id(Long user_account_status_id);

}
