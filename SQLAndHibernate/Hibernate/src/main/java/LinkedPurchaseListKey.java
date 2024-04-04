import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class LinkedPurchaseListKey implements Serializable {
    @Column(name = "student", columnDefinition = "INT(11) UNSIGNED")
    private int studentId;

    @Column(name = "course", columnDefinition = "INT(11) UNSIGNED")
    private int courseId;
}