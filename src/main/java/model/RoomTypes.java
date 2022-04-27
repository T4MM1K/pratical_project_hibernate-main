package model;

import javax.persistence.*;

@Entity
public class RoomTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private int roomTypeId;

    @OneToOne(mappedBy = "roomType")
    private Rooms room;


    private String roomTypeName;

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    @Override
    public String toString() {
        return "RoomTypes{" +
                "roomTypeName='" + roomTypeName + '\'' +
                '}';
    }
}
