package ir.sudoit.infrastructure.persistence.entities;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;


@Entity(name = "Plate")
@Table(name = "plate", uniqueConstraints = {@UniqueConstraint(name = "ht_plate_unique", columnNames = {"number"})})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlateEntity extends AbstractPersistable<Long> implements Serializable {

    private Integer number;

    private String state;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlateEntity that)) return false;
        if (!super.equals(o)) return false;

        if (getNumber() != null ? !getNumber().equals(that.getNumber()) : that.getNumber() != null) return false;
        return getState() != null ? getState().equals(that.getState()) : that.getState() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        return result;
    }
}
