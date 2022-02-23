package demianskv.mywebsite;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts", schema = "website")
@Getter
@Setter
public class Post  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title="";

    @Column(nullable = false)
    @Type(type = "text")
    private String content="";

    @Column(nullable = false)
    private Date createdAt = new Date();

    @Column(nullable = false)
    private boolean visible = true;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private User author;

    private Post(){}

    public Post(User author){
        this.author = author;
    }
}
