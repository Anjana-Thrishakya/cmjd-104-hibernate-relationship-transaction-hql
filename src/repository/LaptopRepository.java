package repository;

import org.hibernate.Session;

import entity.LaptopEntity;

public class LaptopRepository {

    public Integer save(LaptopEntity laptopEntity, Session session) throws Exception {
        Integer id = (Integer) session.save(laptopEntity);
        return id;
    }
}
