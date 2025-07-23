package com.yashh.service;

import com.yashh.exception.IssueException;
import com.yashh.exception.UserException;
import com.yashh.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Long issueId,Long userId,String comment) throws UserException, IssueException;

    void  deleteComment(Long commentId, Long userId) throws UserException, IssueException;

    List<Comment> findCommentByIssueId(Long issueId);

}
