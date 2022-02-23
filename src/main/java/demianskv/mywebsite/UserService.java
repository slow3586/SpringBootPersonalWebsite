package demianskv.mywebsite;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
        addAdminAccount();
    }

    public void addAdminAccount(){
        if(repository.findByUsername("Admin")==null){
            User admin = new User();
            admin.setName("Admin");
            admin.setUsername("Admin");
            repository.save(admin);
        }
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    public User findByName(String name){
        return repository.findByUsername(name);
    }
}
