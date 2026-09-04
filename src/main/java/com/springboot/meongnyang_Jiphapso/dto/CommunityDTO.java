package com.springboot.meongnyang_Jiphapso.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CommunityDTO {
	private Integer comm_no;
	private String comm_type;
	private String comm_title;
	private String comm_writer;
	private String comm_content;
	private String comm_category;
	private String comm_pet_type;
	private int comm_score;
	private String comm_breed;
	private String comm_img;
	private String comm_video;
	private Date comm_date;
	private Date reg_date;
	private int comm_count;
	private int comm_view;
	private int comm_good;
	private int comm_well;
	private String comm_tag;
	private Integer m_no;
	private Integer p_no;
	private Integer pet_no;
}
