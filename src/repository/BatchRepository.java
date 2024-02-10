package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.BatchEntity;

public class BatchRepository {
    public BatchEntity get(Integer id, Session session) throws Exception{
        BatchEntity entity = session.get(BatchEntity.class, id);
        return entity;
    }

    public List<BatchEntity> getAll(Session session){
        String hql = "FROM BatchEntity";
        Query<BatchEntity> query = session.createQuery(hql);
        List<BatchEntity> batchEntities = query.list();
        return batchEntities;
    }

    public List<Object[]> getAllNative(Session session){
        String sql = "SELECT * FROM batch";
        Query query = session.createSQLQuery(sql);
        List<Object[]> batchEntities = query.list();
        return batchEntities;
    }

    public List<String> getAllName(Session session){
        String hql = "SELECT B.batchName FROM BatchEntity B";
        Query<String> query = session.createQuery(hql);
        List<String> batchName = query.list();
        return batchName;
    }
}
