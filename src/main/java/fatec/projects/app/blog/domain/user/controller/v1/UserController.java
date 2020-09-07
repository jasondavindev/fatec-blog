package fatec.projects.app.blog.domain.user.controller.v1;

import fatec.projects.app.blog.domain.user.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/{userId}")
    public UserDto retrieve(@PathVariable("userId") String userId) {
        return UserDto.builder().build();
    }
}
