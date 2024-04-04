import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LinkedPurchaseList")
@Getter
@Setter
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student", columnDefinition = "INT(11) UNSIGNED",insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course", columnDefinition = "INT(11) UNSIGNED",insertable = false, updatable = false)
    private int courseId;
}