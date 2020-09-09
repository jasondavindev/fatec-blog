package fatec.projects.app.blog.domain.comment.controller.v1;

import fatec.projects.app.blog.domain.comment.controller.v1.converter.CommentWebConverter;
import fatec.projects.app.blog.domain.comment.controller.v1.request.CommentRequest;
import fatec.projects.app.blog.domain.comment.controller.v1.response.CommentResponse;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponse create(@RequestBody CommentRequest commentRequest) {
        Comment comment = CommentWebConverter.convertFrom(commentRequest);
        return CommentWebConverter.convertFrom(commentService.create(comment));
    }
}
