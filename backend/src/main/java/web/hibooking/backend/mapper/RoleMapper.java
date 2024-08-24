package web.hibooking.backend.mapper;

import org.mapstruct.Mapper;
import web.hibooking.backend.dto.request.RoleCreationRequest;
import web.hibooking.backend.dto.response.RoleResponse;
import web.hibooking.backend.entities.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toRole(RoleCreationRequest request);
    RoleResponse toRoleResponse(Role role);
}