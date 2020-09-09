package fatec.projects.app.blog.domain.comment.repository;

import fatec.projects.app.blog.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
