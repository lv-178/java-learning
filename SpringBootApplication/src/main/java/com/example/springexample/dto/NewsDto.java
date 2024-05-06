package com.example.springexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewsDto {
    private Integer id;
    private String header;
    private String text;
    private String date;

    @Override
    public String toString() {
        return "{\n\t\"id\": \"" + id + "\",\n\t\"header\": \"" + header +
                "\",\n\t\"text\": \"" + text + "\",\n\t\"date\": \"" + date + "\"\n}";
    }
}
