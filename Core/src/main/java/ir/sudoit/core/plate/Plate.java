package ir.sudoit.core.plate;

import ir.sudoit.core.shared.SelfValidating;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Plate extends SelfValidating<Plate> implements Serializable {

    @Min(0)
    private Long id;


    private Integer number;


    private String state;

    public Plate(Integer number, String state) {
        this.number = number;
        this.state = state;
    }
}
