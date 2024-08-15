package academy.nextskill.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDate enrolledAt;
    private Double progress;

    public Enrollment() {
        this.enrolledAt = LocalDate.now();
        this.progress = 0.0;
    }

    @PrePersist
    public void onCreate() {
        this.enrolledAt = LocalDate.now();
        this.progress = 0.0;
    }

}
