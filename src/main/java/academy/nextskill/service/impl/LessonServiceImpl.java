package academy.nextskill.service.impl;

import academy.nextskill.model.Course;
import academy.nextskill.model.Lesson;
import academy.nextskill.repository.LessonRepository;
import academy.nextskill.service.CourseService;
import academy.nextskill.service.LessonService;
import academy.nextskill.utils.dto.LessonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final CourseService courseService;

    @Override
    public Lesson create(LessonDTO lesson) {
        Course course = courseService.getById(lesson.getCourseId());
        Lesson lessonEntity = Lesson.builder()
                .title(lesson.getTitle())
                .content(lesson.getContent())
                .order(lesson.getOrder())
                .mediaUrl(lesson.getMediaUrl())
                .course(course)
                .build();
        return lessonRepository.save(lessonEntity);
    }

    @Override
    public Lesson getById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lesson> getAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson update(Long id, LessonDTO lesson) {
        Lesson le = this.getById(id);
        le.setTitle(lesson.getTitle());
        le.setContent(lesson.getContent());
        le.setOrder(lesson.getOrder());
        le.setMediaUrl(lesson.getMediaUrl());
        le.setCourse(courseService.getById(lesson.getCourseId()));
        return lessonRepository.save(le);
    }

    @Override
    public void delete(Long id) {
        Lesson le = this.getById(id);
        lessonRepository.deleteById(le.getId());
    }
}
