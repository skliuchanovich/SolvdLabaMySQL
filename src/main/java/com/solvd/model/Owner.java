package com.solvd.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Owner {
    private int id;
    private String name;
    private String contactInfo;
}