package academy.nextskill.controller;

import academy.nextskill.service.EnrollmentService;
import academy.nextskill.utils.dto.EnrollmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    private ResponseEntity<?> create(@RequestBody EnrollmentDTO req) {
        return ResponseEntity.status(201).body(enrollmentService.create(req));
    }

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(enrollmentService.getAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }

    @PutMapping("/{id}/progress")
    private ResponseEntity<?> updateProgress(@PathVariable Long id, @RequestBody Map<String, Double> req) {
        enrollmentService.updateProgress(id, req.get("progress"));
        return ResponseEntity.noContent().build();
    }
}
