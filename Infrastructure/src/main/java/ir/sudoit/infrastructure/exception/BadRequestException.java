package ir.sudoit.infrastructure.exception;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class BadRequestException extends GlobalException{


    @Serial
    private static final long serialVersionUID = 6395881354874100822L;

    public BadRequestException(final String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }
}
