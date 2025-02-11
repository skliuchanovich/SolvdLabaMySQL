package com.solvd.service;

import com.solvd.dao.IAnimalDAO;
import com.solvd.dao.jdbc.AnimalDAO;

import java.util.ResourceBundle;

public class AnimalService {

    public static IAnimalDAO getSelectedAnimal() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        if  (resourceBundle.getString("type").equals("jdbc")){
            return new AnimalDAO();
        } else {
            return new com.solvd.dao.mybatis.AnimalDAO();
        }
    }
}
