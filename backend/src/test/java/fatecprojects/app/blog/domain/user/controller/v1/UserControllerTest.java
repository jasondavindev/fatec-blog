package fatecprojects.app.blog.domain.user.controller.v1;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.common.handler.GlobalExceptionHandler;
import fatec.projects.app.blog.domain.user.controller.v1.UserController;
import fatec.projects.app.blog.domain.user.entity.User;
import fatec.projects.app.blog.domain.user.service.UserService;
import fatecprojects.app.blog.mocks.MockCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Nested
    class FindByName {
        final String username = "User";

        @Test
        void userFound() throws Exception {
            User userMock = MockCreation.userMock();

            given(userService.findByName(any())).willReturn(userMock);

            mockMvc.perform(get("/v1/users/" + username)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(userMock.getName())));
        }

        @Test
        void userNotFound() throws Exception {
            given(userService.findByName(any())).willThrow(NotFoundException.class);

            mockMvc.perform(get("/v1/users/" + username)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }
    }
}
