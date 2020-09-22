package fatecprojects.app.blog.mocks;

import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.post.controller.v1.converter.PostWebConverter;
import fatec.projects.app.blog.domain.post.controller.v1.response.PostResponse;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.user.entity.User;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Post> postListMock() {
        List<Post> postList = new ArrayList<>();
        postList.add(postMock());
        return postList;
    }

    public static PostResponse postResponseMock() {
        return PostWebConverter.convertFrom(postMock());
    }

    public static List<PostResponse> postResponseListMock() {
        return PostWebConverter.convertFrom(postListMock());
    }
}
