package com.exam.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.exam.dto.EmpDTO;
import com.exam.service.EmpService;

@Component
public class AuthProvider implements AuthenticationProvider {

	@Autowired
	EmpService empService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		//authentication이 로그인한 정보를 저장함
		String emp_id = (String)authentication.getPrincipal(); //emp_id 값
		String emp_pw = (String)authentication.getCredentials(); //emp_pw 값
		
		
		EmpDTO empDTO = empService.searchEmpById(emp_id); //empDTO가 null이면 존재하지 않는 직원. null이 아니면 비밀번호까지 확인
//		String encrptPw = empDTO.getPasswd();  // DB에는 암호화된 비밀번호로 저장되기 때문에 암호화된 값이 변수에 저장됨. 즉, NullPointerExcepion 발생
		
		//로그인 성공시
		UsernamePasswordAuthenticationToken token=null; //token을 사용해서 Authentication으로 반환
		
		//BCryptPasswordEncoder().matches(원래 값, 암호화된 값): 원래값과 암호화된 값을 비교
		if(empDTO!=null && new BCryptPasswordEncoder().matches(emp_pw, empDTO.getEmp_id())) {
			
			List<GrantedAuthority> list = new ArrayList<>();
			
			
			//암호화된 비밀번호 대신 raw 비밀번호로 설정
			empDTO.setEmp_pw(emp_pw);
			token = new UsernamePasswordAuthenticationToken(empDTO, null, list);
			
			return token; //empDTO 리턴. 세션에 저장
		}
		
		//로그인 실패시 예외 발생
		throw new BadCredentialsException("로그인 정보가 일치하지 않습니다.");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}




