package com.xworkz.dto;

import lombok.*;

import java.time.Year;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class RowDto {
    private String softwareName;
    private String version;
    private String developedBy;
    private Year year;
    private boolean openSource;
}
