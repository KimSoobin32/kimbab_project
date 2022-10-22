package com.example.kimbab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class KimbabController {
	@GetMapping({"/", "/kimbab/list"})
	public String list() {
		log.info("list...");
		return "kimbab/list";
	}
	
}
