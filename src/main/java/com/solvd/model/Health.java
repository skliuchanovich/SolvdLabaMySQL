package com.solvd.model;


import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Health {
    private String checkUpDate;
    private String healthStatus;
    private int animalID;
}
