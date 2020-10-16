package fatec.projects.app.blog.domain.post.controller.v1.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PostResponse {
    private Long id;
    private String title;
    private String description;
}
