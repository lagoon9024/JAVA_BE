# JAVA_BE
JAVA_BE study
- use Apache tomcat 9.0
- use jdk 13.0.1
- Referrance : https://edwith.org/boostcourse-web/

---
1. Java Web Application
- WAS(Web application server)에 deploy(설치)되어 동작하는 어플리케이션
- HTML, CSS, 이미지, 자바로 작성된 클래스(Servlet, package, interface etc.), 각종 설정 파일 등 포함

2. Servlet [SERVLET FILES] ([redirect1](/exam31/src/exam/)
- 자바 웹 어플리케이션에서 동적인 처리를 하는 프로그램 역할
- WAS에 동작하는 JAVA Class
- HttpServlet 클래스를 상속받아야 한다
- doGet(), doPost(), service() 와 같은 메서드 들을 오버라이딩하여 개발
- 웹 페이지를 개발할 때 JSP, 서블릿을 조화롭게 사용해야 한다(화면 -> JSP, 기능 -> 서블릿)
- Servlet 3.0이상에선 web.xml을 사용하지 않는다.
- Servlet 3.0이상에선 annotation을 사용한다.  
  2-1. Lifecycle [lifecycle_ex](/exam31/src/exam/LifeCycleServelet.java)
  - init -> service -> destroy
  - WAS는 서블릿 요청을 받으면 해당 서블릿의 메모리 적재여부를 확인
  - 메모리에 없을 시 init()
  - service() 메소드를 통해 request와 response를 처리한다(get, post etc..)
  - was가 종료되거나 web application이 새롭게 갱신될 경우 destroy() 메소드 실행
  
3. JSP [JSP FILES](/exam31/WebContent/)
- MS의 ASP(Active Server Page)라는 웹 개발을 편리하게 해주는 script 엔진을 발표
- ASP에 대항하기 위하여 JSP를 발표(썬마이크로시스템즈)
- Servlet 기술을 사용한다
  3-1. 실행순서
  - 브라우저가 웹서버에 JSP에 대한 요청정보 전달
  - 최초 JSP요청의 경우 JSP 코드를 서블릿 코드로 변환(java파일 생성)
  - 서블릿 코드를 컴파일하여 실행가능한 bytecode로 변환(class파일 생성)
  - 서블릿 클래스를 로딩하고 인스턴스 생성
  - 서블릿이 실행되어 요청처리 및 응답정보 생성
  3-2. 문법
  - 스크립트 요소
    - 선언문 <%! %> : 전역변수 및 메소드 선언
    - 스크립트릿 <% %> : 프로그래밍 코드 기술
    - 표현식 <%=%> : 화면에 출력할 내용 기술 (out.print()로 변환된다)
  - JSP주석 : <%-- --%>
  3-3. 내장객체
  - jsp를 실행하면 서블릿 소스가 생성 및 실행
  - jsp에 입력한 대부분 코드는 서블릿 소스의 __jspService()_ 메소드 안에 삽입되는 코드로 생성
  - 삽입코드 윗부분에 미리 선언된 객체들이 있고, jsp에서 사용가능
  - response, request, application, session, out과 같은 변수를 내장객체라고 함
  - 내장객체는 JSP선언문에서 사용할 수 없다 -> 선언문의 경우 service 외부에 코드가 작성되기 때문에, service()메소드 내부의 지역변수인 내장객체의 사용을 할 수 없다.
  
4. Redirect [redirect1](/exam31/WebContent/redirect01.jsp) [redirect2](/exam31/WebContent/redirect02.jsp)
- HTTP 프로토콜로 정해진 규칙
- 서버는 클라이언트의 요청에 대해 특정 URL로 이동 요청을 할 수 있음 -> redirect
- 상태코드 302로 응답, 헤더 내 location값에 이동할 url을 추가한다
- 클라이언트는 리다이렉션 응답을 받으면 헤더에 포함된 url로 재요청을 보낸다
- 서블릿이나 JSP는 HttpServletResponse 클래스의 sendRedirect()메소드를 사용한다

5. Forwarding [forward1](/exam31/src/exam/frontservelet.java) [foward2](/exam31/src/exam/nextservelet.java)
- HttpServletRequest와 HttpServletResponse를 같은 web application 내에 존재하는 servlet2에게 전송(forward)
- servlet2는 servlet1으로 밭은 req,res를 이용해 요청을 처리하고, 웹브라우저에 결과를 전송
- redirect와 다르게 url은 바뀌지 않고, 브라우저에 req,res는 한번만 발생한다
- jsp와 서블릿 연동에 많이 사용할 것으로 생각된다
