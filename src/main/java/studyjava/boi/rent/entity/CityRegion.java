package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "city_region")
@Getter
@Setter
@ToString
public class CityRegion {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "region_name", nullable = false, length = 20, unique = true)
    private String regionName;

    public CityRegion() {
    }
}
