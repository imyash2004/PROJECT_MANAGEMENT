package com.yashh.controller;
import java.util.List;

import com.yashh.exception.MailsException;
import com.yashh.model.Invitation;
import com.yashh.request.ProjectInvitationRequest;
import com.yashh.service.InvitationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yashh.exception.ChatException;
import com.yashh.exception.ProjectException;
import com.yashh.exception.UserException;
import com.yashh.model.Chat;
import com.yashh.model.Project;
import com.yashh.model.User;
import com.yashh.response.MessageResponse;
import com.yashh.service.ProjectService;
import com.yashh.service.UserService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private InvitationService invitationService;
    

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String tag,
            @RequestHeader("Authorization") String token) throws ProjectException, UserException {
        User user = userService.findUserProfileByJwt(token);
        List<Project> projects = projectService.getProjectsByTeam(user,category,tag);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) throws ProjectException {
        Project project = projectService.getProjectById(projectId);
        return project != null ?
                new ResponseEntity<>(project, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(
            @RequestBody Project project,
                                                 @RequestHeader("Authorization") String token) throws UserException, ProjectException {
        User user = userService.findUserProfileByJwt(token);
        project.setOwner(user);
        Project createdProject = projectService.createProject(project, user.getId());
        userService.updateUsersProjectSize(user,1);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject( @RequestBody Project updatedProject,@PathVariable Long projectId, @RequestHeader("Authorization") String token) throws UserException, ProjectException {
        User user = userService.findUserProfileByJwt(token);
        Project updated = projectService.updateProject(updatedProject,projectId);
        return updated != null ?
                new ResponseEntity<>(updated, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<MessageResponse> deleteProject(@PathVariable Long projectId, @RequestHeader("Authorization") String token) throws UserException, ProjectException {
        User user = userService.findUserProfileByJwt(token);
        
        MessageResponse response =new MessageResponse(projectService.deleteProject(projectId, user.getId()));
        userService.updateUsersProjectSize(user,-1);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/user")
//    public ResponseEntity<List<Project>> getProjectsByOwner(@RequestHeader("Authorization") String token) throws ProjectException {
//        try {
//            User owner = userService.findUserProfileByJwt(token);
//            List<Project> projects = projectService.getProjectsByOwner(owner);
//            return new ResponseEntity<>(projects, HttpStatus.OK);
//        } catch (UserException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }



    @GetMapping("/search")
    public ResponseEntity< List<Project>> searchProjects(
            @RequestParam(required = false) String keyword,
            @RequestHeader("Authorization") String jwt
    ) throws ProjectException, UserException {
        User user=userService.findUserProfileByJwt(jwt);
            List<Project> projects = projectService.searchProjects(keyword,user);
            return ResponseEntity.ok(projects);
    }
    
    @PostMapping("/{userId}/add-to-project/{projectId}")
    public ResponseEntity<MessageResponse> addUserToProject(
            @PathVariable Long userId,
            @PathVariable Long projectId) throws UserException, ProjectException {
        projectService.addUserToProject(projectId, userId);
        MessageResponse response =new MessageResponse("User added to the project successfully");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{projectId}/chat")
    public ResponseEntity<Chat> getChatByProjectId(@PathVariable Long projectId)
            throws ProjectException, ChatException {
        Chat chat = projectService.getChatByProjectId(projectId);
        return chat != null ? ResponseEntity.ok(chat) : ResponseEntity.notFound().build();
    }
    

    
    @PostMapping("/invite")
    public ResponseEntity<MessageResponse> inviteToProject(
            @RequestBody ProjectInvitationRequest req) throws MailsException, MessagingException {

        // Validate the email address
        String email = req.getEmail();
        if (email == null || email.trim().isEmpty()) {
            MessageResponse errorResponse = new MessageResponse();
            errorResponse.setMessage("Email address cannot be empty");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        invitationService.sendInvitation(email.trim(), req.getProjectId());

        MessageResponse res = new MessageResponse();
        res.setMessage("User invited to the project successfully");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/accept_invitation")
    public ResponseEntity<Invitation> acceptInvitation(@RequestParam String token,
                                   @RequestHeader("Authorization") String jwt) throws Exception {

        User user=userService.findUserProfileByJwt(jwt);

        Invitation invitation = invitationService.acceptInvitation(token,user.getId());
        projectService.addUserToProject(invitation.getProjectId(),user.getId());

        return new ResponseEntity<>(invitation,HttpStatus.ACCEPTED);
    }

    
}




