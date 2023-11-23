package com.elgen.repository;

import com.elgen.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
//    List<Group> getAllGroups();
//    Group getGroupById(String groupId);
//    Group saveGroup(Group group);
//    void deleteGroup(String groupId);
}
