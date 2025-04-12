package com.son.blindtest.test.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class TestRequest {

    private String imageUrl;

    private String question;

    private String answer;

    private Long categoryId;

}
