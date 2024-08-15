package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
}
