package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "adress")
@Getter
@Setter
@ToString
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street street;

    @Column(name = "building_number", length = 5)
    private String buildingNumber;

    @Column(name = "floor_count", nullable = false)
    private int floorCount;

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

    public Adress() {
    }
}
