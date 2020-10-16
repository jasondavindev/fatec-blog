package fatec.projects.app.blog.domain.post.controller.v1.converter;

import fatec.projects.app.blog.domain.post.controller.v1.request.PostRequest;
import fatec.projects.app.blog.domain.post.controller.v1.response.PostResponse;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostWebConverter {
    public static PostResponse convertFrom(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .build();
    }

    public static List<PostResponse> convertFrom(List<Post> posts) {
        return posts.stream().map(post -> convertFrom(post)).collect(Collectors.toList());
    }

    public static Post convertFrom(PostRequest postRequest) {
        return Post.builder()
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .user(
                        User.builder()
                        .id(postRequest.getUser())
                        .build()
                )
                .build();
    }
}
