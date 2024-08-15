package academy.nextskill.service;

import academy.nextskill.model.Enrollment;
import academy.nextskill.utils.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {
    Enrollment create(EnrollmentDTO enrollment);
    List<Enrollment> getAll();
    Enrollment getById(Long id);
    void updateProgress(Long id, Double progress);
}
