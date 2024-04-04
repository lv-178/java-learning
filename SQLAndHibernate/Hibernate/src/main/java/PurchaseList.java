import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
@Getter
@Setter
public class PurchaseList {
    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "student_name",columnDefinition = "varchar(500)", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name",columnDefinition = "varchar(500)", insertable = false, updatable = false)
    private String courseName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
