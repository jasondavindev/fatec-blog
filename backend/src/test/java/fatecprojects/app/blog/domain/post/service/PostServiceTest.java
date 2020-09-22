package fatecprojects.app.blog.domain.post.service;


import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.repository.PostRepository;
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
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @DisplayName("Create valid post")
    @Test
    void creation_success() {
        Post post = MockCreation.postMock();
        when(postRepository.save(any())).thenReturn(post);

        Assertions.assertEquals(postService.create(post),post);
    }

    @DisplayName("Find valid post by ID")
    @Test
    void search_success() {
        Post post = MockCreation.postMock();
        when(postRepository.findById(any())).thenReturn(Optional.of(post));

        Assertions.assertEquals(postService.findPost(any()),post);
    }

    @DisplayName("Find post with invalid Id")
    @Test
    void search_fail() {
        when(postRepository.findById(any())).thenReturn(Optional.empty());

        Assertions.assertThrows(NotFoundException.class,() -> postService.findPost(any()));
    }

    @DisplayName("Find posts by valid userId")
    @Test
    void search_by_user_success() {
        List<Post> postList = MockCreation.postListMock();
        when(postRepository.findByUserId(any())).thenReturn(Optional.of(postList));

        Assertions.assertEquals(postService.retrievePostsOfUser(any()),postList);
    }

    @DisplayName("Find posts with invalid userId")
    @Test
    void search_by_user_fail() {
        when(postRepository.findByUserId(any())).thenReturn(Optional.empty());

        Assertions.assertEquals(postService.retrievePostsOfUser(any()), Collections.emptyList());
    }
}
