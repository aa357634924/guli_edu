package com.rj.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * TODO
 *  jwt 生成单点登录token的规则
 *  分为3部分：
 *      1.头信息-header
 *      2.有效载体-claim-可以包含用户信息
 *      3.签名哈希-hash算法，防卫标志-secret
 * @author rj
 * @version 1.0
 * @date 2020-11-06 20:42
 */
public class JwtUtil {
    // 设置过期时间，可以自定义
    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    // 设置防伪标志，可以自定义
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    /**
     * 生成token
     * @Param id，nickname 是用户信息，可以根据需要自行设定
     * */
    public static String getJwtToken(String id, String nickname){
        String JwtToken = Jwts.builder()
                // 设置头信息  规则类型是固定格式
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // 设置token过期时间
                .setSubject("rj-edu") // 工程名
                .setIssuedAt(new Date()) // 登录成功生成token时的系统时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) // 登录成功生成token后的过期时间
                // 设置用户信息，可以根据需要自行设定
                .claim("id", id)
                .claim("nickname", nickname)
                // 加密规则
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }

    /**
     * 根据token获取会员id
     * @param String
     * @return
     */
    public static String getMemberIdByJwtToken(String token) {
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }
}
