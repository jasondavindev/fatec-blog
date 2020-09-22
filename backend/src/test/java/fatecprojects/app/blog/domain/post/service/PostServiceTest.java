package fatecprojects.app.blog.domain.post.service;


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
}
