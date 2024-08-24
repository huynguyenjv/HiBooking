package web.hibooking.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.hibooking.backend.dto.request.RoleCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.RoleResponse;
import web.hibooking.backend.service.RoleService;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
@FieldDefaults( level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {

    RoleService roleService;

    @PostMapping("/create")
    public ApiResponse<RoleResponse> create(@RequestBody RoleCreationRequest request){
        if(request.getName() == null || request.getName().isEmpty())
            return new ApiResponse<>(400, "Role name is required", null);

        return ApiResponse.<RoleResponse>builder()
                .result(roleService.initRoles(request))
                .code(1000)
                .message("Role created successfully")
                .build();
    }
}
