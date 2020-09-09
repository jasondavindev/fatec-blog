package fatec.projects.app.blog.domain.comment.service;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment retrieve(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment found"));
    }
}
