package demianskv.mywebsite;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post createPost(User author){
        Post post = new Post(author);
        return addPost(post);
    }

    public Post addPost(Post post){
        repository.save(post);
        return post;
    }

    public Optional<Post> findById(Integer id){
        return repository.findById(id);
    }

    public Iterable<Post> findAll(){
        return repository.findAll();
    }
}
