package com.springboot.newproject.controller;

import com.springboot.newproject.entity.Stack;
import com.springboot.newproject.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class StackController {

    @Autowired
    private StackService stackService;
    @GetMapping("/stacks")
    public List<Stack> fetchStackList(){
        return stackService.fetchStackList();
    }

    @GetMapping("/stacks/{id}")
    public Stack findStackById(@PathVariable("id") int departmentId){
        return stackService.findStackById(departmentId);
    }

    @PostMapping("/stacks")
    public Stack saveStack(@RequestBody Stack stack){
        return stackService.saveStack(stack);
    }

    //get stack information
    @PutMapping("/stacks/{id}")
    public Stack updateStack(@PathVariable("id") int departmentId, @RequestBody Stack stack){
      return stackService.updateStackById(departmentId, stack);
    }

    @PutMapping("/stacks/release/{id}")
    public Stack releaseStack(@PathVariable("id") int stackId){
       return stackService.releaseStack(stackId);
    }

}
