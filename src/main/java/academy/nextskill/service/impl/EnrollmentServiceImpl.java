package academy.nextskill.service.impl;

import academy.nextskill.model.Enrollment;
import academy.nextskill.repository.EnrollmentRepository;
import academy.nextskill.service.CourseService;
import academy.nextskill.service.EnrollmentService;
import academy.nextskill.service.UserService;
import academy.nextskill.utils.dto.EnrollmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final UserService userService;
    private final CourseService courseService;

    @Override
    public Enrollment create(EnrollmentDTO enrollment) {
        return enrollmentRepository.save(
                Enrollment.builder()
                        .user(userService.getById(enrollment.getUserId()))
                        .course(courseService.getById(enrollment.getCourseId()))
                        .build()
        );
    }

    @Override
    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateProgress(Long id, Double progress) {
        Enrollment enrollment = this.getById(id);
        enrollment.setProgress(progress);
        enrollmentRepository.save(enrollment);
    }
}
