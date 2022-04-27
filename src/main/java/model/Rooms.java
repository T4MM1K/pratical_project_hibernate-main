package model;

import javax.persistence.*;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_number")
    private int roomNumber;

    private String pricePerNight;
    private int maxPeople;

    @OneToOne
    @JoinColumn(name = "room_type_id")
    private RoomTypes roomType;

    public String getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "pricePerNight='" + pricePerNight + '\'' +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
