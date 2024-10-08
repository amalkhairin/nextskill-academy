package academy.nextskill.repository;

import academy.nextskill.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    @Query(value = "INSERT INTO enrollments(user_id, course_id, progress) VALUES (:userId, :courseId, :progress) RETURNING *", nativeQuery = true)
    Enrollment create(@Param("userId") Long userId, @Param("courseId") Long courseId, @Param("progress") Double progress);

    @Query(value = "UPDATE enrollments SET progress = COALESCE(:progress, enrollments.progress) WHERE user_id = :userId AND course_id = :courseId RETURNING *", nativeQuery = true)
    Enrollment update(@Param("userId") Long userId, @Param("courseId") Long courseId, @Param("progress") Double progress);

    @Override
    @Query(value = "SELECT * FROM enrollments", nativeQuery = true)
    List<Enrollment> findAll();

    @Query(value = "SELECT * FROM enrollments WHERE user_id = :userId", nativeQuery = true)
    List<Enrollment> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM enrollments WHERE user_id = :userId AND course_id = :courseId", nativeQuery = true)
    Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);

    @Query(value = "SELECT * FROM enrollments WHERE course_id = :courseId", nativeQuery = true)
    List<Enrollment> findAllByCourseId(Long courseId);

    @Override
    @Query(value = "SELECT * FROM enrollments WHERE id = :id", nativeQuery = true)
    Optional<Enrollment> findById(Long id);

    @Modifying(flushAutomatically = true)
    @Query(value = "DELETE FROM enrollments WHERE id = :id", nativeQuery = true)
    int delete(Long id);
}
