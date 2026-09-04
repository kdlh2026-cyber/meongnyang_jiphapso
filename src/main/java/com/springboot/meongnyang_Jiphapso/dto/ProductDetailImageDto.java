package com.springboot.meongnyang_Jiphapso.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDetailImageDto {
	private int img_no;
	private String img_url;
	private MultipartFile img_urls;
	private String img_content;
	private int sort;
	private int p_no;
}
