package com.yashh.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues")

public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;
    private Long projectID;
    private String priority;
    private LocalDate dueDate;
    private List<String> tags=new ArrayList<>();
    
    // Explicit getters since Lombok is not working properly
    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getStatus() {
        return status;
    }
    
    public Long getProjectID() {
        return projectID;
    }
    
    public String getPriority() {
        return priority;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
    
    public List<String> getTags() {
        return tags;
    }

    @ManyToOne
    private User assignee;

    @JsonIgnore
    @ManyToOne
    private Project project;
    
    @JsonIgnore
    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    
    // Additional getters for related entities
    public User getAssignee() {
        return assignee;
    }
    
    public Project getProject() {
        return project;
    }
   
}


