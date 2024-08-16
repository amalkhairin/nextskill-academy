package academy.nextskill.repository;

import academy.nextskill.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query(value = "INSERT INTO lessons(course_id, order_number, title, content, media_url) VALUES (:courseId, :orderNumber, :title, :content, :mediaUrl) RETURNING *", nativeQuery = true)
    Lesson create(@Param("courseId") Long courseId, @Param("orderNumber") Integer orderNumber, @Param("title") String title, @Param("content") String content, @Param("mediaUrl") String mediaUrl);

    @Query(value = "UPDATE lessons SET order_number = COALESCE(:orderNumber, lessons.order_number), title = COALESCE(:title, lessons.title), content = COALESCE(:content, lessons.content), media_url = COALESCE(:mediaUrl, lessons.media_url) WHERE id = :id RETURNING *", nativeQuery = true)
    Lesson update(@Param("id") Long id, @Param("orderNumber") Integer orderNumber, @Param("title") String title, @Param("content") String content, @Param("mediaUrl") String mediaUrl);

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
