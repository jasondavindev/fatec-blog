package fatec.projects.app.blog.domain.user.controller.v1;

import fatec.projects.app.blog.domain.user.controller.v1.converter.UserWebConverter;
import fatec.projects.app.blog.domain.user.dto.UserDto;
import fatec.projects.app.blog.domain.user.entity.User;
import fatec.projects.app.blog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public UserDto findByName(@PathVariable("username") String username) {
        return UserWebConverter.convertFrom(userService.findByName(username));
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
}
