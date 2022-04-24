package ir.sudoit.infrastructure.delivery.rest;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class PlateRest implements Serializable {


    @Serial
    private static final long serialVersionUID = 7891110830886314196L;

    @NotEmpty
    private Integer number;

    @NotEmpty
    private String state;


}
