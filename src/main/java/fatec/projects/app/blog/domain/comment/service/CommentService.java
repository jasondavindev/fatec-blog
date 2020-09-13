package fatec.projects.app.blog.domain.comment.service;

import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.repository.CommentRepository;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public Comment create(Long postId, Comment comment) {
        Post post = postService.findPost(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public List<Comment> retrieveCommentsFromPost(Long postId) {
        return postService.findPost(postId).getComments();
    }
}
