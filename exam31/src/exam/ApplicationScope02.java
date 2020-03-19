package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationScope02
 */
@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicationScope02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8"); // response type 지정

		PrintWriter out = response.getWriter(); // response 출력 스트림

		ServletContext application = getServletContext(); // application 객체 사용
		try {
			int value = (int) application.getAttribute("value"); // value 값을 얻어온다
			++value;
			application.setAttribute("value", value); // value 값을 저장한다
			out.println("<h1>value : " + value + "</h1>");
		} catch (NullPointerException e) { // value값을 얻어오지 못할 경우 예외처리
			out.println("value is not defined");
		}

	}

}
