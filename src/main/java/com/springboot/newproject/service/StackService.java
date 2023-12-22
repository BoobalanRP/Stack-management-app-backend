package com.springboot.newproject.service;

import com.springboot.newproject.entity.Stack;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StackService {
    public List<Stack> fetchStackList();

   public Stack findStackById(int departmentId);

   public Stack saveStack(Stack stack);

    public Stack updateStackById(int departmentId, Stack stack);

    public Stack releaseStack(int stackId);
}
