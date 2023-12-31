package com.springboot.newproject.repository;

import com.springboot.newproject.Dto.StackDto;
import com.springboot.newproject.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StacksRepository extends JpaRepository<Stack, Long> {

    @Modifying
    @Query("UPDATE Stack s SET s.availability = false WHERE s.id = :stackId")
    void updateAvailabilityStatus(@Param("stackId") Long stackId);


    @Query(value = "SELECT s.id, s.name, s.environment, s.availability, uh.id, uh.frontend_branch, uh.backend_branch, uh.user_email " +
            "FROM stacks s " +
            "LEFT JOIN (" +
            "    SELECT uh1.* " +
            "    FROM usage_history uh1 " +
            "    LEFT JOIN usage_history uh2 ON uh1.stack_id = uh2.stack_id AND uh1.id < uh2.id " +
            "    WHERE uh2.id IS NULL OR uh2.id IS NOT NULL AND uh1.stack_id IS NULL" +
            ") AS uh ON s.id = uh.stack_id " +
            "ORDER BY s.id", nativeQuery = true)
  List<Object[]> fetchAllStacksWithHistory();

}
