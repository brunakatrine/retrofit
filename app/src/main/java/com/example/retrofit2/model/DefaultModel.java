package com.example.retrofit2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DefaultModel implements Serializable {
    private Integer count;
    private String next;
    private String previous;
    private List<Planet> results = new ArrayList<>();
}