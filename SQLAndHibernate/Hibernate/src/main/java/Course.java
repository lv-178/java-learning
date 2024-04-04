import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(500)")
    private String name;

    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum ('DESIGN', 'PROGRAMMING', 'MARKETING', 'MANAGEMENT', 'BUSINESS')")
    private Type type;

    @Column(name = "description", columnDefinition = "varchar(500)")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", columnDefinition = "INT(11) UNSIGNED")
    private Teacher teacherId;

    @Column(name = "students_count", columnDefinition = "INT(11) UNSIGNED", nullable = true)
    private Integer studentsCount;

    @Column(columnDefinition = "INT(11) UNSIGNED", nullable = true)
    private Integer price;

    @Column(name = "price_per_hour", nullable = true)
    private Float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students = new ArrayList<>();
}
