package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateComment;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads")
public class CommentController {

    private final CommentService commentService;
    private final AdService adService;

    @GetMapping("/{id}/comments")
    public ResponseEntity<Comments> getComments(@PathVariable int id) {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (true) {
            return ResponseEntity.ok(commentService.getComments(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable int id) {
        if (!adService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (true) {
            return ResponseEntity.ok(commentService.addComment(id));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int adId, @PathVariable int commentId) {
        if (!adService.exists(adId) || !commentService.exists(commentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (true) {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable int adId,
                                                 @PathVariable int commentId,
                                                 @RequestBody CreateOrUpdateComment commentUpdate) {
        if (!adService.exists(adId) || !commentService.exists(commentId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (false) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        } else if (true) {
            return ResponseEntity.ok(commentService.updateComment(commentId, commentUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
