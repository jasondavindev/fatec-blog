package fatecprojects.app.blog.domain.post.controller.v1;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.post.controller.v1.PostController;
import fatec.projects.app.blog.domain.post.controller.v1.response.PostResponse;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.service.PostService;
import fatecprojects.app.blog.mocks.MockCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @InjectMocks
    private PostController postController;

    @Mock
    private PostService postService;

    @DisplayName("Test retrieve posts by userId with valid userId")
    @Test
    void search_users_posts_success() {
        List<Post> postList = MockCreation.postListMock();
        List<PostResponse> postResponseList = MockCreation.postResponseListMock();
        when(postService.retrievePostsOfUser(any())).thenReturn(postList);

        Assertions.assertEquals(postController.getUserPosts(any()),postResponseList);
    }

    @DisplayName("Test retrieve posts by userId with invalid userId")
    @Test
    void search_users_posts_fail() {
        when(postService.retrievePostsOfUser(any())).thenReturn(Collections.emptyList());

        Assertions.assertEquals(postController.getUserPosts(any()),Collections.emptyList());
    }

    @DisplayName("Test retrieve post with valid postId")
    @Test
    void search_post_success() {
        Post post = MockCreation.postMock();
        PostResponse postResponse = MockCreation.postResponseMock();
        when(postService.findPost(any())).thenReturn(post);

        Assertions.assertEquals(postController.retrievePostById(any()),postResponse);
    }

    @DisplayName("Test retrieve post with invalid postId")
    @Test
    void search_post_fail() {
        Exception exception = new NotFoundException("Post not found");
        when(postService.findPost(any())).thenThrow(exception);

        Assertions.assertThrows(NotFoundException.class,() -> postController.retrievePostById(any()));
    }
}
