package com.springboot.meongnyang_Jiphapso.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.meongnyang_Jiphapso.dao.IProductDao;
import com.springboot.meongnyang_Jiphapso.dto.ProductDetailImageDto;
import com.springboot.meongnyang_Jiphapso.dto.ProductDto;
import com.springboot.meongnyang_Jiphapso.dto.ProductOptionDto;

@Controller
public class ProductController {
	@Autowired
	private IProductDao p_dao;
 
	
	@RequestMapping("/productWriteForm")
	public String productWriteForm() {
		return "admin/product/productWriteForm";
	}
	
	@RequestMapping("/productWrite")
	public String productWrite(ProductDto p_dto, ProductDetailImageDto img_dto, ProductOptionDto o_dto,
			 @RequestParam("o_img") MultipartFile o_img, @RequestParam("img_urls") List<MultipartFile> img_urls,
			 @RequestParam(value="o_quantity", defaultValue="100") int o_quantity, @RequestParam("o_price") int o_price,
			 @RequestParam("o_default") String o_default) throws Exception{
		
		p_dao.ProductWrite(p_dto);
		//p_service.write(p_dto);
	    
	    // 방금 생성된 상품 번호 꺼내기
	    int generatedPno = p_dto.getP_no();
		
	    if(o_price == 0) {
	    	o_dto.setO_quantity(0);
	    }
	    
	    if(!"Y".equals(o_default)) {
	        o_dto.setO_default("N");
	    }
	    
		if(!o_img.isEmpty()) {
			String o_main_img = o_img.getOriginalFilename();
			o_img.transferTo(new File("C:\\SPRINGBOOT\\meongnyang_Jiphapso\\src\\main\\resources\\static\\images\\products\\main\\"+o_main_img));
			o_dto.setO_main_img(o_main_img);
		}
		else {
			o_dto.setO_main_img(null);
		}
		o_dto.setP_no(generatedPno);
		
		p_dao.ProductOptionWrite(o_dto);
		
		int sortOrder = 1;

		for (MultipartFile fname : img_urls) {
		    if (!fname.isEmpty()) {
		        String img_url = fname.getOriginalFilename();
		        fname.transferTo(new File("C:\\SPRINGBOOT\\meongnyang_Jiphapso\\src\\main\\resources\\static\\images\\products\\info\\"+img_url));
		        
		        ProductDetailImageDto detailDto = new ProductDetailImageDto();
		        
		        detailDto.setImg_url(img_url);
		        detailDto.setSort(sortOrder); 
		        detailDto.setP_no(generatedPno);
		        
		        if (sortOrder == 1) {
		            detailDto.setImg_content(img_dto.getImg_content());
		        }
		        
		        sortOrder++;
		        
		        p_dao.ProductDetailImageWrite(detailDto);
		    }
		}		

		return "redirect:main";
	}
}
