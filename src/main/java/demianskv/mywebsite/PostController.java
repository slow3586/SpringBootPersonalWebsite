package demianskv.mywebsite;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    Optional<Post> findById(@PathVariable String id) {
        Integer sId = Integer.parseInt(id);
        return postService.findById(sId);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping(path="/create_empty")
    public ResponseEntity<Post> createEmpty() {
        Post created = postService.createPost(userService.findByName("Admin"));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping(path="/add_json")
    public ResponseEntity<Post> createFromJson(@RequestBody Post post) {
        Post created = postService.addPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping(path="/add")
    public String add() {
        return "addpost";
    }

    @PostMapping(path="/add_form_func")
    public ResponseEntity<Post> createFromForm(@ModelAttribute(name="postForm") Post post) {
        Post created = postService.addPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        //m.addAttribute("error", "Incorrect Username & Password");
        return ResponseEntity.created(location).body(created);
    }
}