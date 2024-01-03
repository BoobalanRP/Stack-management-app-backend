package com.springboot.newproject.service;

import com.springboot.newproject.Dto.StackDto;
import com.springboot.newproject.entity.Stack;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StackService {

    public List<Stack> findAllStacks();

   public Stack findStackById(Long departmentId);

   public Stack saveStack(Stack stack);

    public Stack updateStackById(Long departmentId, Stack stack);

    public Stack releaseStack(Long stackId);

    List<StackDto> findAllStacksWithHistory();
}
