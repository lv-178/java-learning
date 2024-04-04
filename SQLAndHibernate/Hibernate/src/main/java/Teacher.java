import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name="Teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int age;

    @Column(columnDefinition = "INT(11) UNSIGNED")
    private int salary;
}
