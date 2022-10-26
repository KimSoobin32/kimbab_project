package com.example.kimbab;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kimbab.entity.Menu;
import com.example.kimbab.persistence.MenuRepository;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    MenuRepository menuRepository;
    
    //데이터 삽입 테스트
    //@Test
    public void insertTest(){
//        Menu menu = Menu.builder()
//                .cate("food")
//                .content("참치가 들어간 김밥")
//                .price(4000)
//                .soldout(0)
//                .title("참치김밥")
//                .build();
//        menuRepository.save(menu);
//
//        Menu menu2 = Menu.builder()
//                .cate("food")
//                .content("계란이 들어간 김밥")
//                .price(3000)
//                .soldout(0)
//                .title("계란김밥")
//                .build();
//        menuRepository.save(menu2);
//
//        Menu menu3 = Menu.builder()
//                .cate("food")
//                .content("야채가 들어간 김밥")
//                .price(2500)
//                .soldout(0)
//                .title("야채김밥")
//                .build();
//        menuRepository.save(menu3);
//
//        Menu menu4 = Menu.builder()
//                .cate("food")
//                .content("치즈가 들어간 김밥")
//                .price(3500)
//                .soldout(0)
//                .title("치즈김밥")
//                .build();
//        menuRepository.save(menu4);
        Menu menu5 = Menu.builder()
                .cate("drink")
                .content("코카콜라 제로 CAN")
                .price(1900)
                .soldout(0)
                .title("코카콜라 제로")
                .build();
        menuRepository.save(menu5);

    }

    //수정 테스트
    //@Test
    public void updateTest(){
        //데이터 1개 찾아오기
        Optional<Menu> result = menuRepository.findById("402881c784081b1c0184081b26d40003");
        if(result.isPresent()){ //데이터 존재 여부
            Menu menu = result.get();
            menu.setTitle("치즈가득김밥");
            menu.setSoldout(1);
            menuRepository.save(menu);
        }else {
            System.out.println("데이터가 존재하지 않음");
        }
    }

    //데이터 삭제 테스트
    //@Test
    public void deleteTest(){
        Optional<Menu> result = menuRepository.findById("402881c784081b1c0184081b26d40003");
        if(result.isPresent()){
            menuRepository.delete(result.get());
        }else {
            System.out.println("데이터가 존재하지 않음");
        }
    }

    //@Test
//    public void selectAllTest(){
//        List<Menu> list = menuRepository.findAll();
//        for(Menu menu : list){
//            System.out.println(menu);
//        }
//    }




}
