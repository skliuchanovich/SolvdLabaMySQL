package com.solvd.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Diet {
    private int id;
    private String feedingSchedule;
    private int animalID;
}
