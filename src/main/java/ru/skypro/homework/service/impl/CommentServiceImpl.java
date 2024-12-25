package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Comments getComments(int AdId) {
        return null;
    }

    @Override
    public Comment addComment(int AdId) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public void deleteComment(int id) {

    }

    @Override
    public Comment updateComment(int id, CreateOrUpdateComment update) {
        return null;
    }

}
