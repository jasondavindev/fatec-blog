package fatec.projects.app.blog.domain.user.service;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.user.entity.User;
import fatec.projects.app.blog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(this::userNotFoundException);
    }

    private NotFoundException userNotFoundException() {
        return new NotFoundException("User not found");
    }
}
