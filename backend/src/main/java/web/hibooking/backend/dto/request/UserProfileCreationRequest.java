package web.hibooking.backend.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileCreationRequest {
    String firstName;
    String lastName;
    String birthDay;
    String userId;
}
