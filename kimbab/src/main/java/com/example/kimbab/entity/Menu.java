package com.example.kimbab.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Menu  extends BaseEntity{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String mid;   //기본키로 사용할 아이디

    @Column(length = 50, nullable = false)
    private String cate;    //카테고리 (drink/food)

    @Column(length = 100, nullable = false)
    private String title;   //메뉴명

    @Column(length = 10, nullable = false)
    private int price;  //가격

    @Column(length = 1, nullable = false)
    private int soldout;    //매진 여부(0:false, 1:true)

    @Column(length = 20)
    private String tag; //태그(BEST, NEW...)

    @Column(columnDefinition = "TEXT")
    private String content; //설명

    @Column(columnDefinition = "TEXT")
    private String img; //이미지 url


}
