package ru.skypro.homework.service;

import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.model.Comment;

public interface CommentService {
    Comments getComments(int AdId);
    Comment addComment(int AdId);
    boolean exists(int id);
    void deleteComment(int id);
    Comment updateComment(int id, CreateOrUpdateComment update);
}
