package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Servlet이 해야하는 작업들.
		// 1. 클라이언트의 요청을 받는 작업 (파라메터 수집) -> Controller(Servlet)
		// 2. 요청에 따른 처리작업 (비즈니스 로직) -> Model로 따로 분리.(별도의 Java 클래스로)
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		// 3. 요청한 클라이언트에게 응답하는 작업 (프레젠테이션 로직) -> View(JSP)
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
		
		// Servlet과 Model로 회원관리 만들기
		
		
		
	}

}
