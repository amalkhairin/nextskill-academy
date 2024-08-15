package academy.nextskill.controller;

import academy.nextskill.service.LessonCompletionService;
import academy.nextskill.utils.dto.LessonCompletionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/lesson-completions")
@RequiredArgsConstructor
public class LessonCompletionController {
    private final LessonCompletionService lessonCompletionService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody LessonCompletionDTO req) {
        return ResponseEntity.status(201).body(lessonCompletionService.create(req));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(lessonCompletionService.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonCompletionService.getById(id));
    }

    @PutMapping("/{id}/completed")
    private ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestBody Map<String, Boolean> req) {
        lessonCompletionService.updateCompleted(id, req.get("completed"));
        return ResponseEntity.noContent().build();
    }
}
