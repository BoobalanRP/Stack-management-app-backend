package com.springboot.newproject.Dto;

import com.springboot.newproject.entity.Stack;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UsageHistoryDto {

    private String frontendBranch;

    private String backendBranch;
    private String userEmail;

    private int stackId;

    public String getFrontendBranch() {
        return frontendBranch;
    }

    public void setFrontendBranch(String frontendBranch) {
        this.frontendBranch = frontendBranch;
    }

    public String getBackendBranch() {
        return backendBranch;
    }

    public void setBackendBranch(String backendBranch) {
        this.backendBranch = backendBranch;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getStackId() {
        return stackId;
    }

    public void setStackId(int stackId) {
        this.stackId = stackId;
    }
}
