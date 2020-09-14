package fatec.projects.app.blog.domain.post.controller.v1.request;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String description;
    private Long user;
}
