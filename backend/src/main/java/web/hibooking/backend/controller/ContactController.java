package web.hibooking.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.hibooking.backend.dto.request.ContactCreationRequest;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.dto.response.ContactResponse;
import web.hibooking.backend.service.ContactService;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
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
}
