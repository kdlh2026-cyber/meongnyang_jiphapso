package com.springboot.meongnyang_Jiphapso.common;

public class SessionConst {
	 public static final String LOGIN_MEMBER_NO = "loginMemberNo"; // HttpSession attribute
	    public static final String GUEST_TOKEN_COOKIE = "guestToken"; // Cookie name
	    public static final int GUEST_TOKEN_MAX_AGE = 60 * 60 * 24 * 30; // 30일

	    private SessionConst() {}
}
