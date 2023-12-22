package com.springboot.newproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usage_history")
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String frontendBranch;

    @NonNull
    private String backendBranch;

    private String userEmail;

    @ManyToOne // Many UsageHistory entities to One Stack entity
    @JoinColumn(name = "stack_id")
    private Stack stack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }
}
