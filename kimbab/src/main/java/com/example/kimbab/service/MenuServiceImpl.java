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

    @Override
    public String register(MenuDTO dto) {
        log.info("메뉴 등록");
        log.info(dto);

        Menu entity = dtoToEntity(dto);

        Menu result = menuRepository.save(entity);

        return result.getMid();
    }

    @Override
    public List<Menu> getList() {

        List<Menu> list = menuRepository.findAll();
        return list;
    }

    @Override
    public Optional<Menu> getOne(String mid) {
        Optional<Menu> result = menuRepository.findById(mid);

        return result;
    }
}
