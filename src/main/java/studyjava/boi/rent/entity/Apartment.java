package studyjava.boi.rent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "apartment")
@Getter
@Setter
@ToString
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    TypeApartments type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_id")
    Adress adress;

    private double price;

    @Column (name = "room_count")
    private int roomCount;

    private String comment;

    public Apartment() {
    }
}
