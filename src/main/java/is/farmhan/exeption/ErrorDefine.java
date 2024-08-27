package is.farmhan.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorDefine {

    // Bad Request
    INVALID_ARGUMENT("4000", HttpStatus.BAD_REQUEST, "Bad Request: Invalid Arguments"),

    // Not Found
    USER_NOT_FOUND("4040", HttpStatus.NOT_FOUND, "Not Found: User Not Found "),
    CALL_NOT_FOUND("4041", HttpStatus.NOT_FOUND, "Not Found: Call Id Not Found "),


    // Forbidden

    // Server
    AI_SERVER_ERROR("5000", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: AI Server Error"),
    AI_SERVER_REQUEST_ERROR("5001", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: Back Server to AI Server Request Error"),
    AI_SERVER_ERROR_RESPONSE_BODY_ERROR("5002", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: AI Server to Back Server ResponseBody Error"),
    AI_SERVER_ERROR_RESPONSE_DTO_ERROR("5003", HttpStatus.INTERNAL_SERVER_ERROR, "Server Error: AI Server to Back Server Response Dto Error");

    private final String errorCode;
    private final HttpStatus httpStatus;
    private final String message;
}

