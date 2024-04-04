import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class  SubscriptionKey implements Serializable {
    @Column(name = "student_id", columnDefinition = "INT(11) UNSIGNED")
    private int studentId;

    @Column(name = "course_id", columnDefinition = "INT(11) UNSIGNED")
    private int courseId;
}