package com.springboot.meongnyang_Jiphapso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.meongnyang_Jiphapso.dto.CartDTO;

@Mapper
public interface ICartDAO {

    // 장바구니 담기
    int insertCart(CartDTO dto);

    // 수량 변경
    int updateCartQuantity(CartDTO dto);

    // 쇼핑백 추가 여부/수량 변경
    int updateCartBag(CartDTO dto);

    // 단건 삭제
    int deleteCart(@Param("caNo") Long caNo);

    // 선택 삭제
    int deleteCartList(@Param("caNoList") List<Long> caNoList);

    // 회원 장바구니 전체 삭제
    int deleteCartAllByMember(@Param("mNo") Long mNo);

    // 장바구니 1건 조회
    CartDTO selectCartOne(@Param("caNo") Long caNo);

    // 회원 장바구니 목록
    List<CartDTO> selectCartListByMember(@Param("mNo") Long mNo);

    // 비회원 장바구니 목록
    List<CartDTO> selectCartListByToken(@Param("caToken") String caToken);

    // 관리자 전체 장바구니 목록
    List<CartDTO> selectCartListAll();

    // 회원 장바구니 개수
    int countCartByMember(@Param("mNo") Long mNo);

    // 비회원 장바구니 개수 (추가)
    int countCartByToken(@Param("caToken") String caToken);
}