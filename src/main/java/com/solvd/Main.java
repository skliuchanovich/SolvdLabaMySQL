package com.solvd;

import com.solvd.dao.IAnimalDAO;
import com.solvd.dao.mybatis.AnimalDAO;
import com.solvd.service.AnimalService;

public class Main {

    public static void main(String[] args) {

        try {

            IAnimalDAO animalDAO = AnimalService.getSelectedAnimal();
            System.out.println(animalDAO.getEntityByID(2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
