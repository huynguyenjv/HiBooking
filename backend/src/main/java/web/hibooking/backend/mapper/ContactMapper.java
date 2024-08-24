package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import web.hibooking.backend.dto.request.ContactCreationRequest;
import web.hibooking.backend.dto.response.ContactResponse;
import web.hibooking.backend.entities.Contact;
import web.hibooking.backend.entities.User;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    Contact toContact(ContactCreationRequest request);

    @Mapping(target = "userId", source = "user.id")
    ContactResponse toContactResponse(Contact contact);

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
