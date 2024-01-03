package com.springboot.newproject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usage_history")
public class UsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frontendBranch;

    private String backendBranch;

    private String userEmail;


    @ManyToOne
   //@JoinColumn(name = "stack_id")
    private Stack stack;

    @CreationTimestamp
    private LocalDateTime startedAt;


    @Column(columnDefinition = "Datetime default null")
    private LocalDateTime endedAt;

}
