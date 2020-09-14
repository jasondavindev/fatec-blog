package fatec.projects.app.blog.domain.comment.controller.v1.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
    private String userName;
    private String postTitle;
    private String commentary;
}
