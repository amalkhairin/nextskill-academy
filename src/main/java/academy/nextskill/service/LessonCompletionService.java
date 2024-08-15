package academy.nextskill.service;

import academy.nextskill.model.LessonCompletion;
import academy.nextskill.utils.dto.LessonCompletionDTO;

import java.util.List;

public interface LessonCompletionService {
    LessonCompletion create(LessonCompletionDTO lessonCompletion);
    List<LessonCompletion> getAll();
    LessonCompletion getById(Long id);
    void updateCompleted(Long id, Boolean completed);
}
