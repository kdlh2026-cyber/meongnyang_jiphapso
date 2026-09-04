package com.springboot.meongnyang_Jiphapso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springboot.meongnyang_Jiphapso.dto.ProductDetailImageDto;
import com.springboot.meongnyang_Jiphapso.dto.ProductDto;
import com.springboot.meongnyang_Jiphapso.dto.ProductOptionDto;

@Mapper
public interface IProductDao {
	//판매목록
	public List<ProductDto> ProductList();
	//판매목록 상세보기
	public ProductDto ProductView(int p_no);
	//등록
	public int ProductWrite(ProductDto p_dto);
	public int ProductDetailImageWrite(ProductDetailImageDto img_dto);
	public int ProductOptionWrite(ProductOptionDto o_dto);
	//수정
	public int ProductUpdate(ProductDto p_dto);
	//삭제
	public int ProductDelete(int p_no);
}
