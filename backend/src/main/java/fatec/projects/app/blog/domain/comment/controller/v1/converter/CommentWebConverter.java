package fatec.projects.app.blog.domain.comment.controller.v1.converter;

import fatec.projects.app.blog.domain.comment.controller.v1.request.CommentRequest;
import fatec.projects.app.blog.domain.comment.controller.v1.response.CommentResponse;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.user.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class CommentWebConverter {
    public static Comment convertFrom(CommentRequest commentRequest) {
        return Comment.builder()
                .post(new Post())
                .user(
                        User.builder()
                                .id(commentRequest.getUserId())
                                .build()
                )
                .commentary(commentRequest.getCommentary())
                .build();
    }

    public static CommentResponse convertFrom(Comment comment) {
        return CommentResponse.builder()
                .userName(comment.getUser().getName())
                .postTitle(comment.getPost().getTitle())
                .commentary(comment.getCommentary())
                .build();
    }

    public static List<CommentResponse> convertFrom(List<Comment> comments) {
        return comments.stream().map(comment -> convertFrom(comment)).collect(Collectors.toList());
    }
}
