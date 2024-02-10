package repository;

import org.hibernate.Session;

import entity.BatchEntity;
import util.SessionFactoryConfiguration;

public class BatchRepository {
    public BatchEntity get(Integer id, Session session) throws Exception{
        BatchEntity entity = session.get(BatchEntity.class, id);
        return entity;
    }
}
