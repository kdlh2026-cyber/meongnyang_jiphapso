package com.springboot.meongnyang_Jiphapso.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CartDTO {
	 private Long caNo;          // 장바구니번호
	    private String caToken;     // 비회원 식별 토큰
	    private Integer caQuantity; // 수량
	    private String caYn;        // 쇼핑백구매여부 (Y/N)
	    private Integer caQty;      // 쇼핑백 수량
	    private Date caAt;          // 담은일시
	    private Date caUp;          // 수정일시
	    private Long mNo;           // 회원번호 FK
	    private Long pNo;           // 상품번호 FK
	    private Long oNo;           // 상품옵션번호 FK

	    // ----- 상품 조인 조회용 (화면 표시 전용, 테이블 컬럼 아니예요) -----
	    private String pName;       // 상품명
	    private String pMainImg;    // 상품 대표이미지(옵션 이미지)
	    private Long oPrice;        // 옵션 판매가
	    private String oName;       // 옵션명
	    private Integer oQuantity;  // 재고수량(품절 체크용)

	    public CartDTO() {}

	    public Long getCaNo() { return caNo; }
	    public void setCaNo(Long caNo) { this.caNo = caNo; }

	    public String getCaToken() { return caToken; }
	    public void setCaToken(String caToken) { this.caToken = caToken; }

	    public Integer getCaQuantity() { return caQuantity; }
	    public void setCaQuantity(Integer caQuantity) { this.caQuantity = caQuantity; }

	    public String getCaYn() { return caYn; }
	    public void setCaYn(String caYn) { this.caYn = caYn; }

	    public Integer getCaQty() { return caQty; }
	    public void setCaQty(Integer caQty) { this.caQty = caQty; }

	    public Date getCaAt() { return caAt; }
	    public void setCaAt(Date caAt) { this.caAt = caAt; }

	    public Date getCaUp() { return caUp; }
	    public void setCaUp(Date caUp) { this.caUp = caUp; }

	    public Long getMNo() { return mNo; }
	    public void setMNo(Long mNo) { this.mNo = mNo; }

	    public Long getPNo() { return pNo; }
	    public void setPNo(Long pNo) { this.pNo = pNo; }

	    public Long getONo() { return oNo; }
	    public void setONo(Long oNo) { this.oNo = oNo; }

	    public String getPName() { return pName; }
	    public void setPName(String pName) { this.pName = pName; }

	    public String getPMainImg() { return pMainImg; }
	    public void setPMainImg(String pMainImg) { this.pMainImg = pMainImg; }

	    public Long getOPrice() { return oPrice; }
	    public void setOPrice(Long oPrice) { this.oPrice = oPrice; }

	    public String getOName() { return oName; }
	    public void setOName(String oName) { this.oName = oName; }

	    public Integer getOQuantity() { return oQuantity; }
	    public void setOQuantity(Integer oQuantity) { this.oQuantity = oQuantity; }

	    @Override
	    public String toString() {
	        return "CartDTO{" +
	                "caNo=" + caNo +
	                ", caQuantity=" + caQuantity +
	                ", caYn='" + caYn + '\'' +
	                ", mNo=" + mNo +
	                ", pNo=" + pNo +
	                ", oNo=" + oNo +
	                '}';
	    }
}
