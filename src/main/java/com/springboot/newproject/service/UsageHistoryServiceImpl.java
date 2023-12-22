package com.springboot.newproject.service;

import com.springboot.newproject.Dto.UsageHistoryDto;
import com.springboot.newproject.entity.Stack;
import com.springboot.newproject.entity.UsageHistory;
import com.springboot.newproject.repository.StacksRepository;
import com.springboot.newproject.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class UsageHistoryServiceImpl implements UsageHistoryService{
    @Autowired
    private UsageHistoryRepository usageHistoryRepository;

    @Autowired
    private StacksRepository stackRepository;
    @Override
    public List<UsageHistory> fetchUsageHistoryList() {
        return usageHistoryRepository.findAll();
    }

    @Override
    public List<UsageHistory> fetchUsageHistoryListByStackId(int stackId) {
        return usageHistoryRepository.findByStackId(stackId);
    }

    @Override
    @Transactional
    public UsageHistory saveUsageHistoryDto(UsageHistoryDto usageHistoryDto) {
        if (Objects.isNull(usageHistoryDto.getUserEmail()) || usageHistoryDto.getUserEmail().isEmpty() ||
                Objects.isNull(usageHistoryDto.getBackendBranch()) || usageHistoryDto.getBackendBranch().isEmpty() ||
                Objects.isNull(usageHistoryDto.getFrontendBranch()) || usageHistoryDto.getFrontendBranch().isEmpty()) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        UsageHistory usageHistory = new UsageHistory();
        // Set backend and frontend branches
        usageHistory.setBackendBranch(usageHistoryDto.getBackendBranch());
        usageHistory.setFrontendBranch(usageHistoryDto.getFrontendBranch());

        String su = usageHistoryDto.getUserEmail();
        usageHistory.setUserEmail(su);
        // Set stack ID
        Stack stack = new Stack();
        stack.setId(usageHistoryDto.getStackId());
        usageHistory.setStack(stack);

        //change the stack availability status into false
        stackRepository.updateAvailabilityStatus(usageHistoryDto.getStackId());

        return  usageHistoryRepository.save(usageHistory);
    }




}
