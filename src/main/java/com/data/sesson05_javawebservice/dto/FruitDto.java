package com.data.sesson05_javawebservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FruitDto {
    private Long id;
    private String name;
    private Double price;
}
