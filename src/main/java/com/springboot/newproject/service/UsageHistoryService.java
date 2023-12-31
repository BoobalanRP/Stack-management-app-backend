package com.springboot.newproject.service;

import com.springboot.newproject.Dto.UsageHistoryDto;
import com.springboot.newproject.entity.UsageHistory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UsageHistoryService {
    public List<UsageHistory> fetchUsageHistoryList();

   public List<UsageHistory> fetchUsageHistoryListByStackId(Long stackId);

    public UsageHistory saveUsageHistoryDto(UsageHistoryDto usageHistory);


    UsageHistory fetchActiveUsageHistoryByStackId(Long stackId);


    void updateEndedAtForUsageHistoryByStackId(Long stackId);
}
