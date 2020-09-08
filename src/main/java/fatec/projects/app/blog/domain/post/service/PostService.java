package fatec.projects.app.blog.domain.post.service;

import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public List<Post> retrievePostsOfUser(Long userId) {
        return postRepository.findByUserId(userId).orElse(Collections.emptyList());
    }
}
