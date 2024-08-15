package academy.nextskill.service;

import academy.nextskill.model.Course;
import academy.nextskill.utils.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course create(CourseDTO course);
    List<Course> getAll();
    Course getById(Long id);
    Course update(Long id, CourseDTO course);
    void delete(Long id);

    void setIsActive(Long id, boolean isActive);
}
