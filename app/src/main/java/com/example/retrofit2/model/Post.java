package com.example.retrofit2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Passo 4 - Criar classe de modelo de acordo com o recurso utilizado
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
