package fatec.projects.app.blog.domain.post.service;

import fatec.projects.app.blog.common.exception.NotFoundException;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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

    public Post findPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new NotFoundException("Post not found"));
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
