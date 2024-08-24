package web.hibooking.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(100, "Invalid key"),
    USER_EXISTED(101, "User existed"),
    USER_NOT_FOUND(102, "User not found"),
    INVALID_INPUT(103, "Invalid input provided"),
    PERMISSION_DENIED(104, "Permission denied"),
    RESOURCE_NOT_AVAILABLE(105, "Resource not available"),
    OPERATION_FAILED(106, "Operation failed"),
    DATABASE_ERROR(107, "Database error"),
    AUTHENTICATION_FAILED(108, "Authentication failed"),
    EMAIL_ALREADY_EXISTS(109, "Email already exists"),
    USERNAME_ALREADY_EXISTS(110, "Username already exists"),
    PASSWORD_TOO_WEAK(111, "Password too weak"),
    SESSION_EXPIRED(112, "Session expired"),
    CONFLICT(113, "Conflict occurred"),
    SERVICE_UNAVAILABLE(114, "Service temporarily unavailable"),
    USER_NOT_EXISTED(115, "User not exist"),
    USER_NOT_AUTHENTICATED(116, "User not authenticated"),
    ROLE_EXISTED(117, "Role existed"),
    ADDRESS_EXISTED(118, "Address existed"),
    CONTACT_EXISTED(119, "Contact existed"),;

    private int code ;
    private String message;


}
