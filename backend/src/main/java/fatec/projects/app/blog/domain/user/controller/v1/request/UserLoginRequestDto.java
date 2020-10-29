package fatec.projects.app.blog.domain.user.controller.v1.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequestDto {
    @NotBlank
    @NotNull
    private String email;
}
