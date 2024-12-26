package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.model.Comment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default Comments mapToComments(List<Comment> comments) {
        Comments result = new Comments();
        result.setResults(comments);
        result.setCount(comments.size());
        return result;
    }

    @Mapping(source = "text", target = "text")
    CreateOrUpdateComment mapToCreateOrUpdateComment(Comment comment);

    @Mapping(source = "text", target = "text")
    Comment mapFromCreateOrUpdateComment(CreateOrUpdateComment dto);


}
