package com.example.kimbab.service;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.entity.Menu;

public interface MenuService {

    public String register(MenuDTO dto);  //메뉴 등록

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
