package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adress")
@Getter
@Setter
@ToString
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




}
