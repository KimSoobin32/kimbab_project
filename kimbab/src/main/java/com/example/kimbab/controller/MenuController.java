package com.example.kimbab.controller;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MenuController {
	//서비스 객체 주입
	private final MenuService menuService;
	@GetMapping({"/"})
	public String main() {
		log.info("/");
		return "kimbab/list";
	}

	//void 리턴 시 요청 url이 view의 이름이 됨
	@GetMapping({"/kimbab/list"})
	public void list(MenuDTO dto, Model model){
		log.info("list...");	 //리눅스 서버의 경우 앞에 / 쓰면 못 찾을 수 있음 (guestbook/list로 써야 함..)

		//서비스 메서드 호출

		try {
			model.addAttribute("result",menuService.getList());
			log.info("model"+model);

		}catch (Exception e){

			log.error("에러"+e.getMessage());

		}

	}
	
}
