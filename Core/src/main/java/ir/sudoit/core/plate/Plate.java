package ir.sudoit.core.plate;


import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Plate implements Serializable {

    @Min(0)
    private Long id;


    private Integer number;


    private String state;

    public Plate(Integer number, String state) {
        this.number = number;
        this.state = state;
    }
}
