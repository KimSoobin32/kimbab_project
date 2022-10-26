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

    //@Test
    public void getOneTest(){
        String mid = "402881c784081b1c0184081b26b80001";
        MenuDTO result = menuService.getOne(mid);
        System.out.println(result);
    }

    //@Test
    public void updateTest(){
        MenuDTO dto = MenuDTO.builder()
                .mid("402881c784081b1c0184081b26c50002")
                .cate("food")
                .title("원조김밥")
                .price(2500)
                .soldout(1)
                .build();
        Optional<Menu> list = menuService.updateMenu(dto);
        System.out.println("삽입된 메뉴"+list);
    }

    //@Test
    public void deleteTest(){
        MenuDTO dto = MenuDTO.builder()
                .mid("402881c784081b1c0184081b26c50002")
                .build();
        Optional<Menu> list = menuService.deleteMenu(dto);
        System.out.println("삭제된 메뉴"+list);

    }

}
