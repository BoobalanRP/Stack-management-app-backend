package com.springboot.newproject.service;


import com.springboot.newproject.Dto.StackDto;
import com.springboot.newproject.entity.Stack;
import com.springboot.newproject.entity.UsageHistory;
import com.springboot.newproject.repository.StacksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StackServiceImpl implements StackService {

    @Autowired
    private StacksRepository stackRepository;

    @Override
    public List<Stack> findAllStacks() {
        return stackRepository.findAll();
    }

    @Override
    public Stack findStackById(Long departmentId) {
        Optional<Stack> optionalStack = stackRepository.findById(departmentId);
        return optionalStack.orElse(null);
    }

    @Override
    public Stack saveStack(Stack stack) {
        return stackRepository.save(stack);
    }

    @Override
    public Stack updateStackById(Long departmentId, Stack stack) {
        Optional<Stack> optionalStack = stackRepository.findById( departmentId);
        if (optionalStack.isPresent()) {
            Stack stackDB = optionalStack.get();
            if (Objects.nonNull(stack.getName()) && !"".equals(stack.getName())) {
                stackDB.setName(stack.getName());
            }
            if (Objects.nonNull(stack.getEnvironment()) && !"".equals(stack.getEnvironment())) {
                stackDB.setEnvironment(stack.getEnvironment());
            }
            return stackRepository.save(stackDB);
        } else {
            return null;
        }
    }

    @Override
    public Stack releaseStack(Long stackId) {
        Optional<Stack> optionalStack = stackRepository.findById( stackId);
        if (optionalStack.isPresent()) {
            Stack stackDB = optionalStack.get();
            if (!stackDB.getAvailability()) {
                stackDB.setAvailability(true);
            }
            return stackRepository.save(stackDB);
        } else {
            return null;
        }
    }

    @Override
    public List<StackDto> findAllStacksWithHistory() {

        List<Object[]> arrayOfArrays = stackRepository.fetchAllStacksWithHistory();
        List<StackDto> listOfStacks = new ArrayList<>();

        for (Object[] array : arrayOfArrays) {
            StackDto stackDto = new StackDto();
            stackDto.setId((long)array[0]);
            stackDto.setName((String) array[1]);
            stackDto.setEnvironment((String) array[2]);
            stackDto.setAvailability((Boolean) array[3]);

            UsageHistory usageHistory = new UsageHistory();

            long stackId = 0;
            if(array[4] != null){
                stackId = (long) array[4];
            }
            usageHistory.setId(stackId);
            usageHistory.setFrontendBranch((String) array[5]);
            usageHistory.setBackendBranch((String) array[6]);
            usageHistory.setUserEmail((String) array[7]);

            stackDto.setUsageHistory(usageHistory);
            listOfStacks.add(stackDto);
        }
            return listOfStacks;

        }
    }



