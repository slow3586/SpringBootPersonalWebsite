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

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody
    Optional<Post> findById(@PathVariable String id) {
        Integer sId = Integer.parseInt(id);
        return service.findById(sId);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Post> findAll() {
        return service.findAll();
    }

    @GetMapping(path="/create_empty")
    public ResponseEntity<Post> createEmpty() {
        Post created = service.createPost();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PostMapping(path="/add")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        Post created = service.addPost(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}