package academy.nextskill.repository;

import academy.nextskill.model.LessonCompletion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonCompletionRepository extends JpaRepository<LessonCompletion, Long> {

    @Query(value = "SELECT * FROM lesson_completions WHERE user_id = :userId AND lesson_id = :lessonId", nativeQuery = true)
    Optional<LessonCompletion> findByUserIdAndLessonId(Long userId, Long lessonId);

    @Override
    @Query(value = "SELECT * FROM lesson_completions", nativeQuery = true)
    List<LessonCompletion> findAll();

    @Query(value = "SELECT * FROM lesson_completions WHERE user_id = :userId", nativeQuery = true)
    List<LessonCompletion> findAllByUserId(Long userId);

    @Override
    @Query(value = "SELECT * FROM lesson_completions WHERE id = :id", nativeQuery = true)
    Optional<LessonCompletion> findById(Long id);

    @Modifying(flushAutomatically = true)
    @Query(value = "DELETE FROM lesson_completions WHERE id = :id", nativeQuery = true)
    int delete(Long id);
}
