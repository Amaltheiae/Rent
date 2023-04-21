package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "street")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Street {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name", nullable = false, length = 50, unique = true)
    private String streetName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", nullable = false)
    CityRegion regionCity;

}
