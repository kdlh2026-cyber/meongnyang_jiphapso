package com.springboot.meongnyang_Jiphapso.common;

import java.util.UUID;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GuestTokenUtil {
    private GuestTokenUtil() {}

    /** 요청에 guestToken 쿠키가 있으면 반환, 없으면 새로 발급해서 응답에 심고 반환 */
    public static String resolveGuestToken(HttpServletRequest request, HttpServletResponse response) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (SessionConst.GUEST_TOKEN_COOKIE.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        String newToken = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(SessionConst.GUEST_TOKEN_COOKIE, newToken);
        cookie.setPath("/");
        cookie.setMaxAge(SessionConst.GUEST_TOKEN_MAX_AGE);
        response.addCookie(cookie);
        return newToken;
    }

    /** 쿠키 신규 발급 없이 조회만 함 (없으면 null). 뱃지 카운트처럼 굳이 새 토큰을 만들 필요 없는 경우 */
    public static String readGuestToken(HttpServletRequest request) {
        if (request.getCookies() == null) return null;
        for (Cookie cookie : request.getCookies()) {
            if (SessionConst.GUEST_TOKEN_COOKIE.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
