package academy.nextskill.service.impl;

import academy.nextskill.model.Course;
import academy.nextskill.repository.CourseRepository;
import academy.nextskill.service.CourseService;
import academy.nextskill.utils.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course create(CourseDTO course) {
        Course courseEntity = Course.builder()
                .title(course.getTitle())
                .description(course.getDescription())
                .build();
        return courseRepository.save(courseEntity);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course update(Long id, CourseDTO course) {
        Course courseEntity = this.getById(id);
        courseEntity.setTitle(course.getTitle());
        courseEntity.setDescription(course.getDescription());
        return courseRepository.save(courseEntity);
    }

    @Override
    public void delete(Long id) {
        Course course = this.getById(id);
        courseRepository.deleteById(course.getId());
    }

    @Override
    public void setIsActive(Long id, boolean isActive) {
        Course course = this.getById(id);
        course.setActive(isActive);
        courseRepository.save(course);
    }
}
