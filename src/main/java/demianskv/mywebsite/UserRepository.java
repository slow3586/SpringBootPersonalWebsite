package demianskv.mywebsite;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
    public User findByName(String name);
}
