# 항해 일지

스프링 주특기 과제 : 나만의 블로그만들기
http://mjpage.shop

</br>
</br>

## 📖프로젝트 미리보기
**<로그인 화면>**</br>
<img width = 700px src="https://user-images.githubusercontent.com/98693746/171530916-1c23d727-91bb-4708-9046-6ef27699c61d.png"></br>
</br>
**<회원가입 화면>**</br>
<img width = 700px src="https://user-images.githubusercontent.com/98693746/171530938-b5fb041d-eca4-47f6-8e31-26b6cad3219e.png"></br>
</br>
**<메인 페이지>**</br>
<img width = 700px src="https://user-images.githubusercontent.com/98693746/171530978-ac4e35c9-61ae-421d-bc67-1efd384c1ae2.png"></br>
</br>
**<글쓰기 페이지>**</br>
<img width = 700px src="https://user-images.githubusercontent.com/98693746/171531033-af88f60c-f4c8-4457-8141-22a52efaa0c2.png"></br>
</br>
**<상세 페이지>**</br>
<img width = 700px src="https://user-images.githubusercontent.com/98693746/171531089-d2bf6e9d-6af1-456b-a7e1-0f020f1636b3.png"></br>
</br>

## 📚 __Stacks__ 

<div>
  
#### Server 
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  
#### Framework
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white">
  
#### Language
  <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
  
#### Database
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  
#### View
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white"/>
  
#### Tool
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"><img src="https://img.shields.io/badge/Git-00000?style=for-the-badge&logo=Git&logoColor=F05032]"/><img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white]"/>
</br>
</br>


## ❗❕프로젝트 요구사항
1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 날짜를 조회하기
    - 작성 날짜 기준으로 내림차순 정렬하기
2. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
3. 게시글 조회 API
    - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기 
    (검색 기능이 아닙니다. 간단한 게시글 조회만 구현해주세요.)
4. 게시글 수정 API
    - API를 호출할 때 입력된 비밀번호를 비교하여 동일할 때만 글이 수정되게 하기
5. 게시글 삭제 API
    - API를 호출할 때 입력된 비밀번호를 비교하여 동일할 때만 글이 삭제되게 하기
-----------------------------------------------------------------------------
1. 회원 가입 API
    - 닉네임, 비밀번호, 비밀번호 확인을 request에서 전달받기
    - 닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 구성하기
    - 비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`로 만들기
    - 비밀번호 확인은 비밀번호와 정확하게 일치하기
    - 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." 라는 에러메세지를 response에 포함하기
2. 로그인 API
    - 닉네임, 비밀번호를 request에서 전달받기
    - 로그인 버튼을 누른 경우 닉네임과 비밀번호가 데이터베이스에 등록됐는지 확인한 뒤, 하나라도 맞지 않는 정보가 있다면 "닉네임 또는 패스워드를 확인해주세요"라는 에러 메세지를 response에 포함하기
3. 로그인 검사
    - `아래 API를 제외하고` 모두 로그인 토큰을 전달한 경우만 정상 response를 전달받을 수 있도록 하기
        - 회원가입 API
        - 로그인 API
        - 게시글 목록 조회 API
        - 게시글 조회 API
        - 댓글 목록 조회 API
    - 로그인 토큰을 전달하지 않은 채로 로그인이 필요한 API를 호출한 경우 "로그인이 필요합니다." 라는 에러 메세지를 response에 포함하기
    - 로그인 토큰을 전달한 채로 로그인 API 또는 회원가입 API를 호출한 경우 "이미 로그인이 되어있습니다."라는 에러 메세지를 response에 포함하기
4.  댓글 목록 조회 API
    - 로그인 토큰을 전달하지 않아도 댓글 목록 조회가 가능하도록 하기
    - 조회하는 게시글에 작성된 모든 댓글을 목록 형식으로 response에 포함하기
    - 제일 최근 작성된 댓글을 맨 위에 정렬하기
5. 댓글 작성 API
    - 로그인 토큰을 전달했을 때에만 댓글 작성이 가능하도록 하기
    - 로그인 토큰을 전달하지 않은 채로 댓글 작성란을 누르면 "로그인이 필요한 기능입니다." 라는 에러 메세지를 response에 포함하기
    - 댓글 내용란을 비워둔 채 API를 호출하면 "댓글 내용을 입력해주세요" 라는 에러 메세지를 response에 포함하기
6. 댓글 수정 API
    - 로그인 토큰에 해당하는 사용자가 작성한 댓글만 수정 가능하도록 하기
    - API를 호출한 경우 기존 댓글의 내용을 새로 입력한 댓글 내용으로 바꾸기
7. 댓글 삭제 API
    - 로그인 토큰에 해당하는 사용자가 작성한 댓글만 삭제 가능하도록 하기
8. 회원가입 테스트 코드 작성
    - 회원가입시 구현한 아래 조건을 검사하는 테스트 코드를 작성하기
        - 닉네임은 `최소 3자 이상, 알파벳 대소문자(a~z, A~Z), 숫자(0~9)`로 이루어져 있어야 합니다.
        - 비밀번호는 `최소 4자 이상이며, 닉네임과 같은 값이 포함된 경우 회원가입에 실패`합니다.
        - 비밀번호 확인은 비밀번호와 정확하게 일치해야 합니다.
        - 데이터베이스에 존재하는 닉네임을 입력한 채 회원가입 버튼을 누른 경우 "중복된 닉네임입니다." 라는 에러 메세지를 response에 포함하기
    - 테스트 코드 실행 시 실제로는 데이터베이스에 연결되지 않도록 하기
    - 각 조건 별로 2개 이상의 테스트 케이스가 존재하도록 하기
