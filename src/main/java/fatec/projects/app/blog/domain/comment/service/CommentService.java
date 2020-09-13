package fatec.projects.app.blog.domain.comment.service;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.repository.CommentRepository;
import fatec.projects.app.blog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public Comment create(Long postId, Comment comment) {
        postService.findPost(postId);
        comment.getPost().setId(postId);
        return commentRepository.save(comment);
    }

    public Comment retrieve(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment found"));
    }
}
