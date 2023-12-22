package com.springboot.newproject.repository;

import com.springboot.newproject.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StacksRepository extends JpaRepository<Stack, Long> {

    @Modifying
    @Query("UPDATE Stack s SET s.availability = false WHERE s.id = :stackId")
    void updateAvailabilityStatus(@Param("stackId") int stackId);
}
