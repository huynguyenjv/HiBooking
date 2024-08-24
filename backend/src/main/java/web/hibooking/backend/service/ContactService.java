package web.hibooking.backend.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import web.hibooking.backend.dto.request.ContactCreationRequest;
import web.hibooking.backend.dto.response.ContactResponse;
import web.hibooking.backend.entities.Contact;
import web.hibooking.backend.entities.User;
import web.hibooking.backend.exception.AppException;
import web.hibooking.backend.exception.ErrorCode;
import web.hibooking.backend.mapper.ContactMapper;
import web.hibooking.backend.repository.ContactRepository;
import web.hibooking.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ContactService {

    ContactRepository contactRepository;
    UserRepository userRepository;
    ContactMapper contactMapper;

    public ContactResponse createByUserId(ContactCreationRequest request){

        if(contactRepository.findContactByUserId(request.getUserId()).isPresent())
            throw new AppException(ErrorCode.CONTACT_EXISTED);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_FOUND));

        Contact contact = contactMapper.toContact(request);
        contact.setUser(user);

        return contactMapper.toContactResponse(contactRepository.save(contact));
    }
}
