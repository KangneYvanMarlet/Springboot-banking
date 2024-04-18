package com.icekiwi.banking.dto;

import lombok.Data;

@Data
public class UserDto {

    private Integer operationCount;
    private Integer dailyOperationCount;
    private String matricule;
    private String username;
    private String subName;

}
