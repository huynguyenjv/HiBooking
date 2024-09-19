package web.hibooking.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.RoleCreationRequest;
import web.hibooking.backend.dto.response.RoleResponse;
import web.hibooking.backend.entities.Role;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.enums.ErrorCode;
import web.hibooking.backend.mapper.RoleMapper;
import web.hibooking.backend.repository.RoleRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {

    RoleRepository roleRepository;
    RoleMapper roleMapper;

    public RoleResponse initRoles(RoleCreationRequest request){
        if(roleRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.ROLE_EXISTED);
        Role role = roleMapper.toRole(request);

        return roleMapper.toRoleResponse(roleRepository.save(role));
    }
}
