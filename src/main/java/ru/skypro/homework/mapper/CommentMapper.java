package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.model.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "count", expression = "java(comments.size())")
    @Mapping(source = "comments", target = "results")
    Comments mapToComments(List<Comment> comments);

    @Mapping(source = "text", target = "text")
    CreateOrUpdateComment mapToCreateOrUpdateComment(Comment comment);

    @Mapping(source = "text", target = "text")
    Comment mapFromCreateOrUpdateComment(CreateOrUpdateComment dto);


}
