import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            CriteriaBuilder builderCourse = session.getCriteriaBuilder();
            CriteriaQuery<Course> criteriaCourse = builderCourse.createQuery(Course.class);
            criteriaCourse.select(criteriaCourse.from(Course.class));

            CriteriaBuilder builderStudent = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteriaStudent = builderStudent.createQuery(Student.class);
            criteriaStudent.select(criteriaStudent.from(Student.class));

            CriteriaBuilder builderPurchaseList = session.getCriteriaBuilder();
            CriteriaQuery<PurchaseList> criteriaPurchaseList = builderPurchaseList.createQuery(PurchaseList.class);
            criteriaPurchaseList.select(criteriaPurchaseList.from(PurchaseList.class));

            List<Student> studentsList = session.createQuery(criteriaStudent).getResultList();
            List<Course> coursesList = session.createQuery(criteriaCourse).getResultList();

            List<PurchaseList> purchaseList = session.createQuery(criteriaPurchaseList).list();

            List<LinkedPurchaseList> linkedPurchaseList = new ArrayList<>();
            for (PurchaseList purchase : purchaseList) {
                for (Course course : coursesList) {
                    if (purchase.getCourseName().equals(course.getName())) {
                        for (Student student : studentsList) {
                            if (student.getName().equals(purchase.getStudentName())) {
                                LinkedPurchaseList linked = new LinkedPurchaseList();
                                linked.setCourseId(course.getId());
                                linked.setStudentId(student.getId());
                                LinkedPurchaseListKey key = new LinkedPurchaseListKey();
                                key.setCourseId(course.getId());
                                key.setStudentId(student.getId());
                                linked.setId(key);
                                linkedPurchaseList.add(linked);
                            }
                        }
                    }
                }
            }
            for (LinkedPurchaseList l : linkedPurchaseList) {
                System.out.println(l.getCourseId() + " " + l.getStudentId());
                session.persist(l);
            }
            transaction.commit();
            sessionFactory.close();

        } catch (Exception e) {
            System.out.println("exception");
            e.printStackTrace();
        }
    }
}
