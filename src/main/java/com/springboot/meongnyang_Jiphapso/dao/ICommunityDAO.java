package com.springboot.meongnyang_Jiphapso.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.springboot.meongnyang_Jiphapso.dto.CommunityDTO;

@Mapper
public interface ICommunityDAO {
	// 게시글 전체 조회(select)
	public List<CommunityDTO> communityAllList();
	
	
	// 목록에서 게시글 필터(카테고리와 펫 타입)하여 조회(select)
	public List<CommunityDTO> communitySelectList(@Param("comm_type") String comm_type,
												  @Param("comm_pet_type") String comm_pet_type,
												  @Param("comm_category") String comom_category
												  );
	
	// 게시글 상세보기 조회(select)
	public CommunityDTO communityView(int comm_no);
	
	// 게시글 작성하기(insert)
	public int communityWrite(CommunityDTO commDto);
	
	// 게시글 수정하기(update)
	public int communityUpdate(CommunityDTO commDto);
	
	// 게시글 삭제하기(delete)
	public int communityDelete(int comm_no);
}
