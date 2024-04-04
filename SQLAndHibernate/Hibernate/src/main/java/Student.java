import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name="Students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int age;

    @Column (name = "registration_date")
    private Date registrationDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    List<Course> courses = new ArrayList<>();
}
