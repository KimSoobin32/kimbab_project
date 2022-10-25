package com.example.kimbab;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.entity.Menu;
import com.example.kimbab.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private MenuService menuService;

    //@Test
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

    //@Test
    public void getListTest(){
        List<Menu> list =  menuService.getList();
        list.stream().forEach(menu -> {
            System.out.println(menu);
        });
    }

    @Test
    public void getOneTest(){
        String mid = "402881c784081b1c0184081b26b80001";
        Optional<Menu> result = menuService.getOne(mid);
        if(result.isPresent()) {
            System.out.println(result.get());
        }else{
            System.out.println("데이터 없음");
        }
    }

}
