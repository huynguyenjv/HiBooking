package web.hibooking.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import web.hibooking.backend.dto.request.ContactCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.ContactResponse;
import web.hibooking.backend.service.ContactService;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
@FieldDefaults( level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ContactController {

    ContactService contactService;

    @PostMapping("/create")
    public ApiResponse<ContactResponse> create(@RequestBody ContactCreationRequest request){
        return ApiResponse.<ContactResponse>builder()
                .result(contactService.createByUserId(request))
                .code(1000)
                .message("Create contact successfully")
                .build();
    }

    @PutMapping("/update")
    public ApiResponse<ContactResponse> update(@RequestBody ContactCreationRequest request){
        return ApiResponse.<ContactResponse>builder()
                .result(contactService.updateByUserId(request))
                .code(1000)
                .message("Update contact successfully")
                .build();
    }
}
