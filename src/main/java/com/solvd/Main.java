package com.solvd;

import com.solvd.dao.jdbc.AnimalDAO;
import com.solvd.dao.jdbc.CatDAO;
import com.solvd.dao.jdbc.HealthDAO;
import com.solvd.model.Animal;
import com.solvd.model.Cat;
import com.solvd.model.Health;

public class Main {

    public static void main(String[] args) {
        HealthDAO healthDAO = new HealthDAO();
        System.out.println(healthDAO.getEntityByID(1));
        AnimalDAO animalDAO = new AnimalDAO();
        System.out.println(animalDAO.getEntities());
        CatDAO catDAO = new CatDAO();
        System.out.println(catDAO.getEntityByID(1));

    }
}
