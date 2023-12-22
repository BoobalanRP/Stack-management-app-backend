package com.springboot.newproject.repository;

import com.springboot.newproject.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {

    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId")
    List<UsageHistory> findByStackId(@Param("stackId") int stackId);

}

