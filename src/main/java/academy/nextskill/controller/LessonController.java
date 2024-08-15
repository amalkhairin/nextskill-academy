package academy.nextskill.controller;

import academy.nextskill.service.LessonService;
import academy.nextskill.utils.dto.LessonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody LessonDTO req) {
        return ResponseEntity.status(201).body(lessonService.create(req));
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody LessonDTO req) {
        return ResponseEntity.ok(lessonService.update(id, req));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        String msg = "";
        lessonService.delete(id);
        msg = "Lesson with id " + id + " deleted";
        return ResponseEntity.ok().body(msg);
    }
}
