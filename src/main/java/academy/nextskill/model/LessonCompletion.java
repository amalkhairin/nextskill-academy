package academy.nextskill.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "lesson_completions")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class LessonCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private Boolean completed;
    private LocalDate completedAt;

    public LessonCompletion() {
        this.completedAt = LocalDate.now();
    }

    @PrePersist
    public void onCreate() {
        this.completedAt = LocalDate.now();
    }
}
