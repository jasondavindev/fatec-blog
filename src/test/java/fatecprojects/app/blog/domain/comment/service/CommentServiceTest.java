package fatecprojects.app.blog.domain.comment.service;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.comment.entity.Comment;
import fatec.projects.app.blog.domain.comment.repository.CommentRepository;
import fatec.projects.app.blog.domain.comment.service.CommentService;
import fatec.projects.app.blog.domain.post.service.PostService;
import fatecprojects.app.blog.mocks.MockCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {
    @InjectMocks
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PostService postService;

    @DisplayName("When is passed valid post")
    @Test
    void creation_success() {
        Comment commentMock = MockCreation.commentMock();
        when(postService.findPost(any())).thenReturn(MockCreation.postMock());
        when(commentRepository.save(any())).thenReturn(commentMock);

        Assertions.assertEquals(commentService.create(1L, commentMock), commentMock);
    }

    @DisplayName("When is passed invalid post")
    @Test
    void creation_fail() {
        Comment commentMock = MockCreation.commentMock();
        when(postService.findPost(any())).thenThrow(new NotFoundException("Post not found"));

        Assertions.assertThrows(NotFoundException.class, () -> commentService.create(1L, commentMock));
    }
}
