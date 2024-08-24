package web.hibooking.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import web.hibooking.backend.dto.request.AddressCreationRequest;
import web.hibooking.backend.dto.response.AddressResponse;
import web.hibooking.backend.dto.response.ApiResponse;
import web.hibooking.backend.service.AddressService;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class AddressController {

    AddressService addressService;

    @PostMapping("/create")
    public ApiResponse<AddressResponse> create( @RequestBody AddressCreationRequest request) {
        return ApiResponse.<AddressResponse>builder()
                .result(addressService.createByUserId(request))
                .code(1000)
                .message("Address created successfully")
                .build();
    }
}
