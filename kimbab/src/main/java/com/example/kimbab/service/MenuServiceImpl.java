package com.example.kimbab.service;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.entity.Menu;
import com.example.kimbab.persistence.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    //유효성 검사를 위한 메서드(아이디 검사)
    private void validate(MenuDTO dto){
        if(dto == null){
            throw new RuntimeException("Menu cannot be null");
        }
        if(dto.getMid() == null){
            throw new RuntimeException("mid cannot be null");
        }
    }

    @Override
    public String register(MenuDTO dto) {
        log.info("메뉴 등록");
        log.info(dto);
        validate(dto);
        Menu entity = dtoToEntity(dto);

        Menu result = menuRepository.save(entity);

        return result.getMid();
    }

    @Override
    public List<Menu> getList() {
        log.info("메뉴 리스트 조회");
        List<Menu> list = menuRepository.findAll();
        return list;
    }

    @Override
    public Optional<Menu> getOne(String mid) {
        log.info("메뉴 조회");
        Optional<Menu> result = menuRepository.findById(mid);

        return result;
    }

    @Override
    public Optional<Menu> updateMenu(MenuDTO dto) {
        log.info("메뉴 수정");
        validate(dto);
        Menu entity = dtoToEntity(dto);
        menuRepository.save(entity);
        //수정 후 데이터 자신의 데이터 목록을 리턴(해당 유저 아이디에 해당하는 목록이 나옴)
        return menuRepository.findById(entity.getMid());
    }

    @Override
    public Optional<Menu> deleteMenu(MenuDTO dto) {
        log.info("메뉴 삭제");
        validate(dto);
        Menu entity = dtoToEntity(dto);
        menuRepository.delete(entity);
        return menuRepository.findById(entity.getMid());
    }
}
