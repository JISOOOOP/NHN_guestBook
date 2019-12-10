# NHN_guestBook

NHN ROOKIE:19 심지수

개발 환경
- git
- 자바스크립트 모듈 : jQuery 정도만 사용
- 서버 : 자바 8+, 스프링 5+(SpringMVC), Tomcat8.x, JSP(View), MyBatis
- DB : MySQL
- 편집기 : STS http://spring.io/tools/sts/all

구현 목표 스펙
- 이메일, 비밀번호, 본문을 입력 받아 DB에 추가
- 글 등록 시 현재 시각도 기록
- DB에 있는 내용을 최신 글이 맨 위에 오도록 페이징 없이 출력
- 비밀번호를 입력 받아 방명록 글 수정 가능
- 수정 시 별도 테이블 컬럼에 수정 시각 기록
- 이메일이 올바른지 서버/클라이언트 모두에서 체크
- 위 각 항목에 대해 최소 1개의 JUnit TestCase 작성(옵션)
