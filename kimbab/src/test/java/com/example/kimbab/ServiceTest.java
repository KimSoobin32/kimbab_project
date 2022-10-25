package com.example.kimbab;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private MenuService menuService;

    @Test
    public void insertTest(){
        MenuDTO dto = MenuDTO.builder()
                .cate("drink")
                .title("사이다")
                .price(1500)
                .soldout(1)
                .content("ICE CAN")
                .build();
        String mid = menuService.register(dto);
        System.out.println("삽입된 메뉴 아이디"+mid);
    }
}
