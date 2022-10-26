package com.example.kimbab.controller;

import com.example.kimbab.domain.MenuDTO;
import com.example.kimbab.entity.Menu;
import com.example.kimbab.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
	//http://localhost/kimbab/list
	//void 리턴 시 요청 url이 view의 이름이 됨
	@GetMapping({"/kimbab/list"})
	public void list(MenuDTO dto, Model model){	//전체 리스트 조회
		log.info("list...");	 //리눅스 서버의 경우 앞에 / 쓰면 못 찾을 수 있음 (guestbook/list로 써야 함..)

		//서비스 메서드 호출
		try {
			model.addAttribute("result",menuService.getList());
			log.info("model"+model);

		}catch (Exception e){
			log.error("에러"+e.getMessage());

		}
	}

	//메뉴 등록
	@GetMapping("/kimbab/register")
	public void register(){
		log.info("register GET");
	}

	/*
	RedirectAttributes는 리다이렉트가 발생하기 전에 모든 플래시 속성을 세션에 복사한다.
	리다이렉션 이후에는 저장된 플래시 속성을 세션에서 모델로 이동시킨다. 헤더에 파라미터를 붙이지 않기 때문에 URL에 노출되지 않는다.
	RedirectAttributes가 제공하는 메소드 addFlashAttribute()
	addFlashAttribute() 는 리다이렉트 직전 플래시에 저장하는 메소드다. 리다이렉트 이후에는 소멸한다.
	
	forward는 사용자 요청 객체가 계속 유지되기 때문에 글쓰기하고 여러번 새로고침 누르면 DB에 글이 여러번 저장될 수
	있기 때문에 수정/삭제/삽입은 redirect(get->post->get) 사용을 권장
	*/
	@PostMapping("/kimbab/register")
	public String register(MenuDTO dto, RedirectAttributes redirectAttributes){
		log.info("register POST");

		String mid = menuService.register(dto);

		redirectAttributes.addFlashAttribute("msg","mid: "+mid+" 등록 완료");

		return "redirect:/kimbab/list";
	}

	//상세 보기
	//ModelAttribute : 매개변수를 결과 페이지에 넘겨줄 때 사용 (어떤 처리 안하고 바로 넘겨줄 때..
	@GetMapping("/kimbab/read")
	public void read(String mid, Model model){
		log.info("메뉴 상세 보기");
		MenuDTO dto = menuService.getOne(mid);
		log.info(dto.getRegDate());
		model.addAttribute("dto",dto);

	}

	//메뉴 수정
	@PostMapping("/kimbab/update")
	public String update(MenuDTO dto, RedirectAttributes redirectAttributes){
		log.info("menu update");
		try {
			Optional<Menu> result = menuService.updateMenu(dto);
			if(result.isPresent()){
				redirectAttributes.addFlashAttribute("msg","mid: "+dto.getMid()+" 수정 완료");
			}else {
				throw new Exception("update 실패");
			}
		}catch (Exception e){
			log.error("에러"+e.getMessage());

		}

		return "redirect:/kimbab/list"; 
	}

	//메뉴 삭제
	@PostMapping("/kimbab/delete")
	public String delete(MenuDTO dto, RedirectAttributes redirectAttributes){
		log.info("menu delete");
		try {
			Optional<Menu> result = menuService.deleteMenu(dto);
			if(result.isEmpty()){
				redirectAttributes.addFlashAttribute("msg","mid: "+dto.getMid()+" 삭제 완료");
			}else {
				throw new Exception("delete 실패");
			}
		}catch (Exception e){
			log.error("에러"+e.getMessage());

		}

		return "redirect:/kimbab/list";
	}
		
	

	
}
