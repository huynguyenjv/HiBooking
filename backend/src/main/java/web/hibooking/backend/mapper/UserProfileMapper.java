package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import web.hibooking.backend.dto.request.UserProfileCreationRequest;
import web.hibooking.backend.dto.response.UserProfileResponse;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.entities.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    UserProfile toUserProfile(UserProfileCreationRequest request);

    @Mapping(target = "userId", source = "user.id")
    UserProfileResponse toUserProfileResponse(UserProfile userProfile);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(String userId) {
        if (userId == null) {
            return null;
        }
        User user = new User();
        user.setId(userId);
        return user;
    }
}
