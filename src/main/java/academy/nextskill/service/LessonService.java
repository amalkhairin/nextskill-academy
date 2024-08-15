package academy.nextskill.service;

import academy.nextskill.model.Lesson;
import academy.nextskill.utils.dto.LessonDTO;

import java.util.List;
import java.util.Optional;

public interface LessonService {
    Lesson create(LessonDTO lesson);
    Lesson getById(Long id);
    List<Lesson> getAll();
    Lesson update(Long id, LessonDTO lesson);
    void delete(Long id);
}
