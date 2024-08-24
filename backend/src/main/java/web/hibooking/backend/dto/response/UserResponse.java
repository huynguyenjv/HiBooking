package web.hibooking.backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import web.hibooking.backend.entities.Address;
import web.hibooking.backend.entities.Role;

import java.util.HashSet;
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
