package academy.nextskill.controller;

import academy.nextskill.service.CourseService;
import academy.nextskill.utils.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody CourseDTO req) {
        return ResponseEntity.status(201).body(courseService.create(req));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody CourseDTO req) {
        return ResponseEntity.ok(courseService.update(id, req));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        String msg = "";
        courseService.delete(id);
        msg = "Course with id " + id + " deleted";
        return ResponseEntity.ok().body(msg);
    }

}
