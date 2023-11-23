package com.elgen.repository;

import com.elgen.model.Follower;
import com.elgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {
//    @Override
//    List<Follower> findAll();
//    List<Follower> findFollowerByUser_id(User user);
//    List<Follower> findFollowerByName(User full_name);
//
//    void delete(Follower follower);
//    void deleteByUser_id(User user);
}
