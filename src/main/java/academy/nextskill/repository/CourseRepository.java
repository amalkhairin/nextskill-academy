package academy.nextskill.repository;

import academy.nextskill.model.Course;
import academy.nextskill.model.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "INSERT INTO courses(title, description, is_active) VALUES (:title, :description, :isActive) RETURNING *", nativeQuery = true)
    Course create(
            @Param("title") String title,
            @Param("description") String description,
            @Param("isActive") boolean isActive);

    @Query(value = "UPDATE courses SET title = COALESCE(:title, courses.title), " +
            "description = COALESCE(:description, courses.description), " +
            "is_active = COALESCE(:isActive, courses.is_active) " +
            "WHERE id = :id " +
            "RETURNING *", nativeQuery = true)
    Course update(
            @Param("id") Long id,
            @Param("title") String title,
            @Param("description") String description,
            @Param("isActive") boolean isActive);

    @Override
    @Query(value = "SELECT * FROM courses", nativeQuery = true)
    List<Course> findAll();

    @Override
    @Query(value = "SELECT * FROM courses WHERE id = :id", nativeQuery = true)
    Optional<Course> findById(@Param("id") Long id);

    @Query(value = "SELECT * FROM courses WHERE title = :title", nativeQuery = true)
    Optional<Course> findByTitle(@Param("title") String title);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM courses WHERE id = :id", nativeQuery = true)
    void delete(Long id);

}
