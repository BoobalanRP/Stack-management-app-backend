package com.springboot.newproject.controller;

import com.springboot.newproject.Dto.StackDto;
import com.springboot.newproject.Dto.UsageHistoryDto;
import com.springboot.newproject.entity.Stack;
import com.springboot.newproject.entity.UsageHistory;
import com.springboot.newproject.service.StackService;
import com.springboot.newproject.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StackController {

    @Autowired
    private StackService stackService;

    @Autowired
    private UsageHistoryService usageHistoryService;
    @GetMapping("/stacks")
//    public List<Stack> fetchStackList()
//    {
//        return stackService.findAllStacks();
//
//    }
    public List<StackDto> fetchStackList(){
        return stackService.findAllStacksWithHistory();
    }

    @GetMapping("/stacks/{id}")
    public Stack findStackById(@PathVariable("id") Long stackId){
        return stackService.findStackById(stackId);
    }

    @PostMapping("/stacks")
    public Stack saveStack(@RequestBody Stack stack){
        return stackService.saveStack(stack);
    }

    //get stack information
    @PutMapping("/stacks/{id}")
    public Stack updateStack(@PathVariable("id") Long stackId, @RequestBody Stack stack){
      return stackService.updateStackById(stackId, stack);
    }

    @Transactional
    @PutMapping("stack/release/{id}")

    public void releaseStack( @PathVariable("id") Long stackId){


                stackService.releaseStack(stackId);

        usageHistoryService.updateEndedAtForUsageHistoryByStackId(stackId);
      //  UsageHistory usageHistory =   usageHistoryService.fetchActiveUsageHistoryByStackId(stackId);

//        UsageHistoryDto usageHistoryDto = new UsageHistoryDto();

//        usageHistoryDto.setId(usageHistory.getId());
//        usageHistoryDto.setStackId(usageHistory.getStack().getId());
//        usageHistoryDto.setUserEmail(usageHistory.getUserEmail());
//        usageHistoryDto.setFrontendBranch(usageHistory.getFrontendBranch());
//        usageHistoryDto.setBackendBranch(usageHistory.getBackendBranch());
//        usageHistoryDto.setStartedAt(usageHistory.getStartedAt());
//        usageHistoryDto.setEndedAt(LocalDateTime.now());

//        usageHistoryService.saveUsageHistoryDto(usageHistoryDto);

    }

}
