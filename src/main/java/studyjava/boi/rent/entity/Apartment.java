package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    TypeApartments type;

    @ManyToOne
    @JoinColumn(name = "adress_id")
    Adress adress;

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

    private double price;

    @Column (name = "room_count")
    private int roomCount;

    private String comment;


}
