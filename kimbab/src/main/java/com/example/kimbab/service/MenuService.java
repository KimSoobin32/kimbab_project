package com.example.kimbab.service;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.entity.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuService {

    public String register(MenuDTO dto);  //메뉴 등록

    public List<Menu> getList(); //모든 메뉴 리스트 조회

    public Optional<Menu> getOne(String mid); //해당 아이디의 메뉴 정보 조회

    public Optional<Menu> updateMenu(MenuDTO dto);  //메뉴 수정

    public Optional<Menu> deleteMenu(MenuDTO dto);   //메뉴 삭제

    default Menu dtoToEntity(MenuDTO dto){
        Menu entity = Menu.builder()
                .mid(dto.getMid())
                .cate(dto.getCate())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .soldout(dto.getSoldout())
                .tag(dto.getTag())
                .content(dto.getContent())
                .img(dto.getImg())
                .build();
        return entity;

    }

    default MenuDTO entityToDto(Menu entity){
        MenuDTO dto = MenuDTO.builder()
                .mid(entity.getMid())
                .cate(entity.getCate())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .soldout(entity.getSoldout())
                .tag(entity.getTag())
                .content(entity.getContent())
                .img(entity.getImg())
                .build();
        return dto;
    }
}
