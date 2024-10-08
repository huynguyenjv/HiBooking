package web.hibooking.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    String id;

    @NotBlank(message = "Email is required")
    @Size(min = 1, max = 50, message = "Email must be between 1 and 50 characters")
    @Email
    String email;

    @NotBlank(message = "Password is required")
    String password;

    AddressCreationRequest address;

    ContactCreationRequest contact;

    UserProfileCreationRequest userProfile;

    Set<RoleCreationRequest> roles;


}
