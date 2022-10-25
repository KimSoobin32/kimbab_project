package com.example.kimbab.domain;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuDTO {
    private String mid;
    private String cate;
    private String title;
    private int price;
    private int soldout;
    private String tag;
    private String content;
    private String img;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}
