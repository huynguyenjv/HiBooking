package web.hibooking.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 1, max = 50, message = "Email must be between 1 and 50 characters")
    @NotBlank(message = "Email is required")
    @Email
    String email;

    @Size(min = 1, max = 250, message = "Password must be between 1 and 250 characters")
    @NotBlank(message = "Password is required")
    String password;
}
