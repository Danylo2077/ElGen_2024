package com.elgen.repository;

import com.elgen.model.UserAccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountStatusRepository extends JpaRepository<UserAccountStatus, Long> {

}