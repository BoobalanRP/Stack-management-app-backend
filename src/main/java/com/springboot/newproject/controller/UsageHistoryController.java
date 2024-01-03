package com.springboot.newproject.controller;

import com.springboot.newproject.Dto.UsageHistoryDto;
import com.springboot.newproject.entity.UsageHistory;
import com.springboot.newproject.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsageHistoryController {

    @Autowired
    private UsageHistoryService usageHistoryService;
    @GetMapping("/usagehistory")
    public List<UsageHistory> fetchUsageHistoryList(){
        return usageHistoryService.fetchUsageHistoryList();
    }

    @GetMapping("/usagehistory/{id}")
   public List<UsageHistory> fetchUsageHistoryListByStackId(@PathVariable("id") Long stackId){
        return usageHistoryService.fetchUsageHistoryListByStackId(stackId);
    }

    @PostMapping("/stack/use")
    public UsageHistory saveUsageHistory(@RequestBody UsageHistoryDto usageHistoryDto){
        return usageHistoryService.saveUsageHistoryDto(usageHistoryDto);
    }

}
