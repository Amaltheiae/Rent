package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adress", uniqueConstraints = @UniqueConstraint(columnNames = {"street_id", "building_number", "floor_count"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @Column(name = "building_number", length = 5)
    private String buildingNumber;

    @Column(name = "floor_count", nullable = false)
    private int floorCount;

    @Override
    public String toString() {
        String output = "";
        if (street != null && !"Choose street".equals(street.getStreetName())) {
            output = street.getStreetName() + ", " + buildingNumber +
                    " (поверхів - " + floorCount + ')';
        } else {
            output = "Choose street";
        }
        return output;
    }

}
