package persistence;

import model.Rooms;
import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryRoom {

    private EntityManager em;

    public RepositoryRoom() {
        em = DBUtil.getEntityManager();
    }

    public Rooms searchRoomById(int roomTypeId) {
        return em.find(Rooms.class, roomTypeId);
    }

    public void updateRoomPriceById(String newPrice, int roomTypeId) {
        em.getTransaction().begin();
        String sql = "UPDATE Rooms SET pricePerNight = :price WHERE roomNumber = :id";
        int result = this.em.createQuery(sql)
                .setParameter("price", newPrice)
                .setParameter("id", roomTypeId)
                .executeUpdate();
        em.getTransaction().commit();
        if(result <= 0) {
            System.out.println("Room not registered on system!");
        }
    }
}
