package com.yashh.service;

import java.util.List;

import com.yashh.exception.ChatException;
import com.yashh.exception.ProjectException;
import com.yashh.exception.UserException;
import com.yashh.model.Message;

public interface MessageService {

    Message sendMessage(Long senderId, Long chatId, String content) throws UserException, ChatException, ProjectException;

    List<Message> getMessagesByProjectId(Long projectId) throws ProjectException, ChatException;
}

