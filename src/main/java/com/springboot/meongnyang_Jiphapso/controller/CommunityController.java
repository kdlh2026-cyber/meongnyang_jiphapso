package com.springboot.meongnyang_Jiphapso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.meongnyang_Jiphapso.dto.CommunityDTO;
import com.springboot.meongnyang_Jiphapso.service.CommunityService;

@Controller
public class CommunityController {
	@Autowired
	CommunityService service;
	
	
	// 로그인을 해야 글쓰기로 넘어감(WebSecurity 설정하면 됨)
	@GetMapping("/commWriteForm")
	public String commWriteForm() {
		return "community/communityWriteForm";
	}
	
	// 게시글 글쓰기 등록하기
	@RequestMapping("/commWrite")
	public String commWrite(CommunityDTO dto,
							@RequestParam("uploadFiles") MultipartFile[] uploadFiles) throws Exception{
		
		if (dto.getPet_no() == null || dto.getPet_no() == 0) {
		    dto.setPet_no(null); // 반려동물 번호가 없으면 확실하게 null 처리
		}
		
		service.write(dto, uploadFiles);
		return "redirect:/community/commList";
	}
	
	// 게시글 목록으로 이동
	@RequestMapping("/community/commList") 
	public String commList(Model model) {
		model.addAttribute("list",service.list());
	    return "community/commList";
	}
}
