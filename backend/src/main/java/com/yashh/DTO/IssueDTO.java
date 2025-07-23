package com.yashh.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.yashh.model.Project;
import com.yashh.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//IssueDTO class
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {

 private Long id;
 private String title;
 private String description;
 private String status;
 private Long projectID;
 private String priority;
 private LocalDate dueDate;
 private List<String> tags = new ArrayList<>();
 private Project project;

 // Exclude assignee during serialization
 private User assignee;

 // Explicit setter methods since Lombok is not working properly
 public void setId(Long id) {
     this.id = id;
 }
 
 public void setTitle(String title) {
     this.title = title;
 }
 
 public void setDescription(String description) {
     this.description = description;
 }
 
 public void setStatus(String status) {
     this.status = status;
 }
 
 public void setProjectID(Long projectID) {
     this.projectID = projectID;
 }
 
 public void setPriority(String priority) {
     this.priority = priority;
 }
 
 public void setDueDate(LocalDate dueDate) {
     this.dueDate = dueDate;
 }
 
 public void setTags(List<String> tags) {
     this.tags = tags;
 }
 
 public void setProject(Project project) {
     this.project = project;
 }
 
 public void setAssignee(User assignee) {
     this.assignee = assignee;
 }

}
