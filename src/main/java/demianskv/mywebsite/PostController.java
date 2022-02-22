package demianskv.mywebsite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository repository;

    public PostController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Post> findAll() {
        return repository.findAll();
    }
}