package fatec.projects.app.blog.common.business;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String message;
    private Long timestamp;
}
