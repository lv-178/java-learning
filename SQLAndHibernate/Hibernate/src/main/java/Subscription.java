import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
@Getter
@Setter
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", columnDefinition = "INT(11) UNSIGNED",insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id",columnDefinition = "INT(11) UNSIGNED", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}