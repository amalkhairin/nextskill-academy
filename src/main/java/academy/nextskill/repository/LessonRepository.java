package academy.nextskill.repository;

import academy.nextskill.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Override
    @Query(value = "SELECT * FROM lessons", nativeQuery = true)
    List<Lesson> findAll();

    @Query(value = "SELECT * FROM lessons WHERE order_number = :orderNumber", nativeQuery = true)
    Optional<Lesson> findByOrderNumber(Integer orderNumber);

    @Query(value = "SELECT * FROM lessons WHERE course_id = :courseId AND order_number = :orderNumber", nativeQuery = true)
    Optional<Lesson> findByCourseIdAndOrderNumber(Long courseId, Integer orderNumber);

    @Override
    @Query(value = "SELECT * FROM lessons WHERE id = :id", nativeQuery = true)
    Optional<Lesson> findById(Long id);

    @Query(value = "SELECT * FROM lessons WHERE course_id = :courseId", nativeQuery = true)
    List<Lesson> findAllByCourseId(Long courseId);

    @Modifying(flushAutomatically = true)
    @Query(value = "DELETE FROM lessons WHERE id = :id", nativeQuery = true)
    int delete(Long id);
}
