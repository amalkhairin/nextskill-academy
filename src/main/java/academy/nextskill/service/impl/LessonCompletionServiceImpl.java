package academy.nextskill.service.impl;

import academy.nextskill.model.LessonCompletion;
import academy.nextskill.repository.LessonCompletionRepository;
import academy.nextskill.service.LessonCompletionService;
import academy.nextskill.service.LessonService;
import academy.nextskill.service.UserService;
import academy.nextskill.utils.dto.LessonCompletionDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonCompletionServiceImpl implements LessonCompletionService {
    private final LessonCompletionRepository lessonCompletionRepository;
    private final LessonService lessonService;
    private final UserService userService;

    @Transactional
    @Override
    public LessonCompletion create(LessonCompletionDTO lessonCompletion) {
        LessonCompletion lessonCompletionEntity = LessonCompletion.builder()
                .lesson(lessonService.getById(lessonCompletion.getLessonId()))
                .user(userService.getById(lessonCompletion.getUserId()))
                .build();
        return lessonCompletionRepository.save(lessonCompletionEntity);
    }

    @Override
    public List<LessonCompletion> getAll() {
        return lessonCompletionRepository.findAll();
    }

    @Override
    public LessonCompletion getById(Long id) {
        return lessonCompletionRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCompleted(Long id, Boolean completed) {
        LessonCompletion lessonCompletion = this.getById(id);
        lessonCompletion.setCompleted(completed);
        lessonCompletionRepository.save(lessonCompletion);
    }
}
