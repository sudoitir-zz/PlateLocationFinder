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
public class NotFoundException extends GlobalException{

    @Serial
    private static final long serialVersionUID = 1987419590658013127L;

    public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }
}
