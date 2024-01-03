package com.springboot.newproject.repository;

import com.springboot.newproject.entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {

    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId")
    List<UsageHistory> findByStackId(@Param("stackId") Long stackId);

    @Query("SELECT u FROM UsageHistory u WHERE u.stack.id = :stackId AND u.endedAt IS NULL ORDER BY u.startedAt DESC")
    UsageHistory findActiveUsageHistoryByStackId(@Param("stackId") Long stackId);

    @Modifying
    @Query("UPDATE UsageHistory u SET u.endedAt = CURRENT_TIMESTAMP WHERE u.stack.id = :stackId AND u.endedAt IS NULL")
      void updateEndedAtForUsageHistoryByStackId(@Param("stackId") Long stackId);

}

