import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class PurchaseListKey implements Serializable {
    @Column(name = "student_name",columnDefinition = "varchar(500)")
    private String studentName;

    @Column(name = "course_name",columnDefinition = "varchar(500)")
    private String courseName;
}