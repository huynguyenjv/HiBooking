package web.hibooking.backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String email;
    AddressResponse addressResponse;
    ContactResponse contactResponse;
    UserProfileResponse userProfileResponse;
    Set<String> roles;
}
