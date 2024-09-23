package com.exam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//커스터마이징 처리
		
		//1. 불필요한 인증제거
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
	    .anyRequest().authenticated();
		
		//2. 로그인 관련 작업
		http.csrf().disable();
		
		http.formLogin() //spring security가 제공하는 화면이 아닌 사용자가 만든 로그인 화면으로 인증처리
		    .loginPage("/main") //로그인 페이지 요청매핑값
		    .loginProcessingUrl("/main") //action 값
		    .usernameParameter("emp_id") 
		    .passwordParameter("emp_pw")
		    .defaultSuccessUrl("/adminMenu") //로그인 성공시 리다이렉트되는 요청맵핑값
		    .failureForwardUrl("/main?error=true"); //로그인 실패시 리다이렉트되는 요청맵핑값   
//	    	.successForwardUrl("/adminMenu");    // post 지원 안됨
		
	     //3. csrf 비활성화
		
		 //4. 로그아웃 관련 작업
		 http.logout()
		     .logoutUrl("/logout")   //security가 자동으로 로그아웃 처리해주는 요청맵핑값
		     .logoutSuccessUrl("/main");  //logout 성공시 리다이렉트 되는 요청맵핑값
		     
		return http.build();
	}
	
}