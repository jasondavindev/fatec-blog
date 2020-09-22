package fatec.projects.app.blog.domain.post.controller.v1;

import fatec.projects.app.blog.domain.post.controller.v1.converter.PostWebConverter;
import fatec.projects.app.blog.domain.post.controller.v1.request.PostRequest;
import fatec.projects.app.blog.domain.post.controller.v1.response.PostResponse;
import fatec.projects.app.blog.domain.post.entity.Post;
import fatec.projects.app.blog.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping()
    public PostResponse createPost(@RequestBody PostRequest postRequest) {
        Post post = PostWebConverter.convertFrom(postRequest);
        return PostWebConverter.convertFrom(postService.create(post));
    }

    @GetMapping("/user/{userId}")
    public List<PostResponse> getUserPosts(@PathVariable("userId") Long userId) {
        return PostWebConverter.convertFrom(postService.retrievePostsOfUser(userId));
    }

    @GetMapping("/{postId}")
    public PostResponse retrievePostById(@PathVariable("postId") Long postId) {
        return PostWebConverter.convertFrom(postService.findPost(postId));
    }
}
