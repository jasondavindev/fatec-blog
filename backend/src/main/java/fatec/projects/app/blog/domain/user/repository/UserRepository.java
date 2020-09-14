package fatec.projects.app.blog.domain.user.repository;

import fatec.projects.app.blog.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
