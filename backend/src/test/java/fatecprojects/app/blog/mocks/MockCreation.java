package fatecprojects.app.blog.mocks;

import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.user.entity.User;

public class MockCreation {
    public static User userMock() {
        return User.builder()
                .id(1L)
                .name("User")
                .email("user@mail.com")
                .build();
    }

    public static Post postMock() {
        return Post.builder()
                .id(1L)
                .title("Hello")
                .description("Hello")
                .user(userMock())
                .build();
    }

    public static Comment commentMock() {
        return Comment.builder()
                .commentary("Hello world")
                .build();
    }
}
