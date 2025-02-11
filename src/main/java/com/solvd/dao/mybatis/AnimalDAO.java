package com.solvd.dao.mybatis;

import com.solvd.MyBatisConf;
import com.solvd.dao.IAnimalDAO;
import com.solvd.model.Animal;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AnimalDAO implements IAnimalDAO {
    static SqlSessionFactory sqlSessionFactory = MyBatisConf.buildqlSessionFactory();


    @Override
    public Animal getEntityByID(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Animal animal = session.selectOne("com.solvd.dao.IAnimalDAO.getEntityByID", id);
            return animal;
        }
    }

    @Override
    public List<Animal> getEntities() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<Animal> list = session.selectList("com.solvd.dao.IAnimalDAO.getEntities");
            return list;
        }
    }

    @Override
    public void insert(Animal animal) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.dao.IAnimalDAO.insert", animal);
            session.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.dao.IAnimalDAO.delete", id);
            session.commit();
        }
    }

    @Override
    public void update(int id, Animal animal) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            animal.setId(id);
            session.update("com.solvd.dao.IAnimalDAO.update", animal);
            session.commit();
        }
    }

}
