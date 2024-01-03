package com.springboot.newproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UsageHistoryDto {

    private Long id;
    private String frontendBranch;

    private String backendBranch;
    private String userEmail;
    private Long stackId;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;


}
