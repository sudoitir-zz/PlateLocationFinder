package ir.sudoit.infrastructure.exception;

import lombok.*;

import java.io.Serial;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends Exception{


    @Serial
    private static final long serialVersionUID = -3749829252814174712L;

    private final int code;


    public GlobalException(final int code, final String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
