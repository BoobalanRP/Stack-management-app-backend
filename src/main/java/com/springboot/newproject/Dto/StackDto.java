package com.springboot.newproject.Dto;

import com.springboot.newproject.entity.UsageHistory;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;

import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class StackDto {
    private Long id;
    private String name;
    private String environment;


    private Boolean availability;

   // @OneToMany(mappedBy = "stack", cascade = CascadeType.ALL)
    private UsageHistory usageHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public UsageHistory getUsageHistory() {
        return usageHistory;
    }

    public void setUsageHistory(UsageHistory usageHistory) {
        this.usageHistory = usageHistory;
    }

}
