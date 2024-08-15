package academy.nextskill.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnrollmentDTO {
    private Long id;
    private Long userId;
    private Long courseId;
    private Boolean completed;
}
