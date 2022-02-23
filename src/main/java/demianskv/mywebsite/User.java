package demianskv.mywebsite;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "website")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String name;
}
