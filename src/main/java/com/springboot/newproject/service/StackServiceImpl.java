package com.springboot.newproject.service;

import com.springboot.newproject.entity.Stack;
import com.springboot.newproject.repository.StacksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StackServiceImpl implements StackService{

    @Autowired
    private StacksRepository stackRepository;
    @Override
    public List<Stack> fetchStackList() {
        return stackRepository.findAll();
    }

    @Override
    public Stack findStackById(int departmentId) {
        return stackRepository.findById((long) departmentId).get();
    }

    @Override
    public Stack saveStack(Stack stack) {
        return stackRepository.save(stack);
    }

    @Override
    public Stack updateStackById(int departmentId, Stack stack) {
        Stack stackDB = stackRepository.findById((long) departmentId).get();
        if(Objects.nonNull(stack.getName()) && !"".equals(stackDB.getName())){
            stackDB.setName(stack.getName());
        }
        if(Objects.nonNull(stack.getEnvironment()) && !"".equals(stackDB.getEnvironment())){
            stackDB.setEnvironment(stack.getEnvironment());
        }

        return stackRepository.save(stackDB);

    }

    @Override
    public Stack releaseStack(int stackId) {
        Stack stackDB = stackRepository.findById((long) stackId).get();

        if (!stackDB.getAvailability()) {
            stackDB.setAvailability(true);
        }
        return stackRepository.save(stackDB);
    }


}
