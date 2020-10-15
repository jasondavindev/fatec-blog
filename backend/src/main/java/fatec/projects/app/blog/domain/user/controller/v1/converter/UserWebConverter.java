package fatec.projects.app.blog.domain.user.controller.v1.converter;

import fatec.projects.app.blog.domain.user.controller.v1.response.UserResponse;
import fatec.projects.app.blog.domain.user.dto.UserDto;
import fatec.projects.app.blog.domain.user.entity.User;

public class UserWebConverter {
    public static UserDto convertFrom(User user) {
        return UserDto
                .builder()
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    public static UserResponse convertFromUserToResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
