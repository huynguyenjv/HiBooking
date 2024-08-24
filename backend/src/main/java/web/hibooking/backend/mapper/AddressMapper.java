package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import web.hibooking.backend.dto.request.AddressCreationRequest;
import web.hibooking.backend.dto.response.AddressResponse;
import web.hibooking.backend.entities.Address;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.repository.UserRepository;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    Address toAddress(AddressCreationRequest request);

    @Mapping(target = "userId", source = "user.id") // Map userId từ user trong Address entity
    AddressResponse toAddressResponse(Address address);

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
