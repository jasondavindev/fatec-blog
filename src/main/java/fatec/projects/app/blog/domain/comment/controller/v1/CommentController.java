package fatec.projects.app.blog.domain.comment.controller.v1;

import fatec.projects.app.blog.domain.comment.controller.v1.converter.CommentWebConverter;
import fatec.projects.app.blog.domain.comment.controller.v1.request.CommentRequest;
import fatec.projects.app.blog.domain.comment.controller.v1.response.CommentResponse;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.service.CommentService;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Comment> create(
            @PathVariable("postId") Long postId,
            @RequestBody CommentRequest commentRequest) {
        Post post = postService.findPost(postId);
        Comment comment = CommentWebConverter.convertFrom(commentRequest);
        commentService.create(post, comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<CommentResponse> findComments(
            @PathVariable("postId") Long postId) {
        List<Comment> comments = postService.findPost(postId).getComments();
        return CommentWebConverter.convertFrom(comments);
    }
}
