package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "street")
@Getter
@Setter
@ToString
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name", nullable = false, length = 30, unique = true)
    private String streetName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = false)
    CityRegion regionCity;

    public Street() {
    }
}
