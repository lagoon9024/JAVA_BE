# JAVA_BE
JAVA_BE study
- use Apache tomcat 9.0
- use jdk 13.0.1
- Reference : https://edwith.org/boostcourse-web/

---
### 1. Java Web Application
  - WAS(Web application server)에 deploy(설치)되어 동작하는 어플리케이션
  - HTML, CSS, 이미지, 자바로 작성된 클래스(Servlet, package, interface etc.), 각종 설정 파일 등 포함

### 2. Servlet 
  - [SERVLET FILES](/exam31/src/exam/)  
  - 자바 웹 어플리케이션에서 동적인 처리를 하는 프로그램 역할
  - WAS에 동작하는 JAVA Class
  - HttpServlet 클래스를 상속받아야 한다
  - doGet(), doPost(), service() 와 같은 메서드 들을 오버라이딩하여 개발
  - 웹 페이지를 개발할 때 JSP, 서블릿을 조화롭게 사용해야 한다(화면 -> JSP, 기능 -> 서블릿)
  - Servlet 3.0이상에선 web.xml을 사용하지 않는다.
  - Servlet 3.0이상에선 annotation을 사용한다.  
    #### 2-1. Lifecycle 
    - [lifecycle_ex](/exam31/src/exam/LifeCycleServelet.java)  
    - init -> service -> destroy
    - WAS는 서블릿 요청을 받으면 해당 서블릿의 메모리 적재여부를 확인
    - 메모리에 없을 시 init()
    - service() 메소드를 통해 request와 response를 처리한다(get, post etc..)
    - was가 종료되거나 web application이 새롭게 갱신될 경우 destroy() 메소드 실행

### 3. JSP 
  - [JSP FILES](/exam31/WebContent/)  
  - MS의 ASP(Active Server Page)라는 웹 개발을 편리하게 해주는 script 엔진을 발표
  - ASP에 대항하기 위하여 JSP를 발표(썬마이크로시스템즈)
  - Servlet 기술을 사용한다
    #### 3-1. 실행순서
    - 브라우저가 웹서버에 JSP에 대한 요청정보 전달
    - 최초 JSP요청의 경우 JSP 코드를 서블릿 코드로 변환(java파일 생성)
    - 서블릿 코드를 컴파일하여 실행가능한 bytecode로 변환(class파일 생성)
    - 서블릿 클래스를 로딩하고 인스턴스 생성
    - 서블릿이 실행되어 요청처리 및 응답정보 생성
    #### 3-2. 문법
    - 스크립트 요소
      - 선언문 <%! %> : 전역변수 및 메소드 선언
      - 스크립트릿 <% %> : 프로그래밍 코드 기술
      - 표현식 <%=%> : 화면에 출력할 내용 기술 (out.print()로 변환된다)
    - JSP주석 : <%-- --%>
    #### 3-3. 내장객체
    - jsp를 실행하면 서블릿 소스가 생성 및 실행
    - jsp에 입력한 대부분 코드는 서블릿 소스의 __jspService()_ 메소드 안에 삽입되는 코드로 생성
    - 삽입코드 윗부분에 미리 선언된 객체들이 있고, jsp에서 사용가능
    - response, request, application, session, out과 같은 변수를 내장객체라고 함
    - 내장객체는 JSP선언문에서 사용할 수 없다 -> 선언문의 경우 service 외부에 코드가 작성되기 때문에, service()메소드 내부의 지역변수인 내장객체의 사용을 할 수 없다.

### 4. Redirect 
  - [redirect1](/exam31/WebContent/redirect01.jsp), [redirect2](/exam31/WebContent/redirect02.jsp)  
  - HTTP 프로토콜로 정해진 규칙
  - 서버는 클라이언트의 요청에 대해 특정 URL로 이동 요청을 할 수 있음 -> redirect
  - 상태코드 302로 응답, 헤더 내 location값에 이동할 url을 추가한다
  - 클라이언트는 리다이렉션 응답을 받으면 헤더에 포함된 url로 재요청을 보낸다
  - 서블릿이나 JSP는 HttpServletResponse 클래스의 sendRedirect()메소드를 사용한다

### 5. Forwarding
  - [forward1](/exam31/src/exam/frontservelet.java), [foward2](/exam31/src/exam/nextservelet.java)
  - HttpServletRequest와 HttpServletResponse를 같은 web application 내에 존재하는 servlet2에게 전송(forward)
  - servlet2는 servlet1으로 밭은 req,res를 이용해 요청을 처리하고, 웹브라우저에 결과를 전송
  - redirect와 다르게 url은 바뀌지 않고, 브라우저에 req,res는 한번만 발생한다
  - jsp와 서블릿 연동에 많이 사용할 것으로 생각된다

### 6. Scope
- Application, Session, Request, Page로 이루어져 있다  
![](http://1.bp.blogspot.com/-I9TZP5Q8wUQ/Taap2IYwyhI/AAAAAAAAAOg/68E71KBizEM/s400/scope.bmp)

<sub> 출처 : http://inheritingjava.blogspot.com/2011/04/chapter-42-scope-of-javabeans-in-jsp.html </sub>
- Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
- Session : 웹 브라우저 별로 변수가 관리되는 경우 사용
- Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용
-   Page : 페이지 내에서 지역변수처럼 사용
	#### 6-1 Page scope
	- PageContext 추상 클래스 사용
	- JSP 페이지에서 pageContext라는 내장객체로 사용 가능
	- forward가 될 경우 해당 Page scope에 지정된 변수는 사용할 수 없다
	- 사용방법은 다른 scope와 같다
	- 지역변수처럼 사용된다는 점이 다른 scope들과 다르다
	- jsp에서 pageScope에 값을 저장한 후 해당 값을 EL표기법 등에서 사용할 때 사용
	- 해당 jsp나 서블릿이 실행되는 동안에만 정보를 유지하고자 할 때 사용
	#### 6-2 Request Scope
	- http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용
	- HttpServletRequest 객체를 사용
	- JSP에서는 request 내장변수, 서블릿에서는 HttpServletRequest객체 사용
	- 값을 저장시에는 request 객체의 setAttribute() 메서드, 읽어들일 때는 getAttribute() 메서드를 사용
	- forward시 값을 유지하고자 사용
	#### 6-3 Session scope
	- 웹 브라우저(클라이언트) 별 변수를 관리하고자 할 경우 사용
	- 브라우저의 탭간에는 세션정보가 공유 -> 각각의 탭에서 같은 세션정보 사용 가능
	- HttpSession 인터페이스를 구현한 객체를 사용
	- JSP에서는 session 내장 변수를 사용하고, 서블릿에서는 HttpServletRequest의 getSession() 메서드를 이용하여 session 객체를 얻는다
	- 값을 저장시에는 session 객체의 setAttribute() 메서드, 읽어들일 때는 getAttribute() 메서드를 사용
	- 장바구니처럼 클라이언트별로 유지가 되어야 할 정보가 있을 때 사용
	#### 6-4 Application scope
	- [Application Scope Servlet 1](/exam31/src/exam/ApplicationScope01.java), [Application Scope Servlet 2](/exam31/src/exam/ApplicationScope02.java), [Application Scope JSP](/exam31/WebContent/applicationscope01.jsp)  
	- 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있음(브라우저나 접속위치에 상관 없이 같은 변수를 사용)
	- ServletContext 인터페이스를 구현한 객체를 사용
	- JSP에서는 application 내장 객체를 이용하고, 서블릿의 경우 getServletContext() 메서드를 이용하여 application 객체를 이용
	- 웹 어플리케이션 하나당 하나의 application 객체가 사용됨
	- 값을 저장할 때는 application 객체의 setAttribute() 메서드, 읽어 들일때는 getAttribute() 메서드를 사용
	- 모든 클라이언트가 공통으로 사용해야할 값들이 있을 때 사용


### 7.  EL (Expression Language / 표현언어)
- [EL01](exam31/WebContent/EL01.jsp),  [EL02](exam31/WebContent/EL02.jsp)
- 디자이너, BE, FE 개발자 모두가 보기 좋은 형태의 언어에 대한 고민에서 만들어짐
- 제공 기능
	- JSP의 scope에 맞는 속성 사용
	- 집합 객체에 대한 접근 방법 제공
	- 수치 연산, 관계 연산, 논리 연산자 제공
	- 자바 클래스 메소드 호출 기능 제공
	- 표현언어만의 기본 객체 제공
- 표현 언어의 표현 방법
```java
${expr}
expr : 표현언어가 정의한 문법에 따라 값을 표현하는 식

예제 ::
<b><%=session.getAttribute("id")%></b>님 환영합니다
<b>${sessionScope.id}</b>님 환영합니다
```
- 데이터 타입
	- boolean, integer, float, string, null
```
${<표현1>.<표현2>}
```
- 객체 접근 규칙
	-  표현 1이나 표현 2가 null이면 null을 반환
	-   표현1이 Map일 경우 표현2를 key로한 값을 반환
	-   표현1이 List나 배열이면 표현2가 정수일 경우 해당 index에 해당하는 값을 반환
	-   정수가 아닐 경우에는 오류가 발생
	-   표현1이 객체일 경우는 표현2에 해당하는 getter메소드를 호출한 결과를 반환
- 표현 언어 비활성화 : JSP에 명시하기
	-   <%@ page isELIgnored = "true" %>
	-  페이지 내 위치에 상관없이 페이지 전체에 적용된다

### 8. [JSTL(JSP Standard Tag Library)](https://github.com/lagoon9024/dailystudy/blob/master/200322/0322.md)

### 9. [Maven](https://github.com/lagoon9024/dailystudy/blob/master/200324/0324.md)
- [실습코드](./mavenweb/pom.xml)
- pom.xml을 변경하면 꼭 maven project update를 해주자!
### 10. JDBC
- [실습코드](./jdbcexam)
