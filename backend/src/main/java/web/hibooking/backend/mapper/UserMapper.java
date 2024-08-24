package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import web.hibooking.backend.dto.request.UserCreationRequest;
import web.hibooking.backend.dto.response.AddressResponse;
import web.hibooking.backend.dto.response.ContactResponse;
import web.hibooking.backend.dto.response.UserProfileResponse;
import web.hibooking.backend.dto.response.UserResponse;
import web.hibooking.backend.entities.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRolesToRoleNames")
    @Mapping(target = "userProfileResponse", source = "userProfile")
    @Mapping(target = "contactResponse", source = "contact")
    @Mapping(target = "addressResponse", source = "address")
    UserResponse toUserResponse(User user);

    List<UserResponse> toUsers(List<User> users);

    @Named("mapRolesToRoleNames")
    default Set<String> mapRolesToRoleNames(Set<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream()
                .map(Role::getName) // Giả sử Role có phương thức getName() trả về tên của role
                .collect(Collectors.toSet());
    }

    AddressResponse toAddressResponse(Address address);
    ContactResponse toContactResponse(Contact contact);
    UserProfileResponse toUserProfileResponse(UserProfile userProfile);
}
