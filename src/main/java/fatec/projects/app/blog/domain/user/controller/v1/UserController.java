package fatec.projects.app.blog.domain.user.controller.v1;

import fatec.projects.app.blog.domain.user.controller.v1.converter.UserWebConverter;
import fatec.projects.app.blog.domain.user.dto.UserDto;
import fatec.projects.app.blog.domain.user.entity.User;
import fatec.projects.app.blog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public UserDto retrieve(@PathVariable("userId") Long userId) {
        return UserWebConverter.convertFrom(userService.retrieve(userId));
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
