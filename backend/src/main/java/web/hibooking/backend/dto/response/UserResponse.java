package web.hibooking.backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponse {
    String email;
    String password;
//    String firstName;
//    String lastName;
//    String birthDay;
//    String createdAt;
//    String deletedAt;
}
