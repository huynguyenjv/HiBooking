package web.hibooking.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.AddressCreationRequest;
import web.hibooking.backend.dto.response.AddressResponse;
import web.hibooking.backend.entities.Address;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.exception.ErrorCode;
import web.hibooking.backend.mapper.AddressMapper;
import web.hibooking.backend.repository.AddressRepository;
import web.hibooking.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults( level = lombok.AccessLevel.PRIVATE, makeFinal = true )
public class AddressService {

    UserRepository userRepository;
    AddressRepository addressRepository;
    AddressMapper addressMapper;

    public AddressResponse createByUserId(AddressCreationRequest request) {

        if ( addressRepository.findAddressByUserId(request.getUserId()).isPresent() )
            throw new AppException(ErrorCode.ADDRESS_EXISTED);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        Address address = addressMapper.toAddress(request);
        address.setUser(user);

        return addressMapper.toAddressResponse(addressRepository.save(address));

    }
}
