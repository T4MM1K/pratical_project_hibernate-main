package persistence;

import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryBookings {

    private EntityManager em;

    public RepositoryBookings() {
        em = DBUtil.getEntityManager();
    }



}
