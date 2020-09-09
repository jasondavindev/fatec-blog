package fatec.projects.app.blog.domain.comment.controller.v1.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CommentRequest {
    @JsonProperty("commentary")
    @NotEmpty
    @NotNull
    private String commentary;

    @JsonProperty("user")
    @NotNull
    private Long userId;

    @JsonProperty("post")
    @NotNull
    private Long postId;
}
