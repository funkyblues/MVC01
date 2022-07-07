package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");
		// 1. 파라메터 수집(VO로!)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		//MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		// System.out.println(vo.toString());
		// 입력받은 vo 객체를 DB제어 Model과 연동시켜서  MemberDAO 객체를 이용하여 insert해주면 된다.
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		// PrintWriter out = response.getWriter();
		if (cnt > 0) {
			// 가입 성공
			// out.println("insert success"); 
			
			// 다시 회원리스트 보기로 가야함. (/MVC01/memberList.do)
			response.sendRedirect("/MVC01/memberList.do");
			
		} else {
			// 가입 실패 -> 예외 객체를 만들어서 WAS에게 던지자.
			throw new ServletException("Not insert");
		}

	}

}
