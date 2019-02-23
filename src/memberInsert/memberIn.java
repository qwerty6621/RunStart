package memberInsert;

public interface memberIn {
	/*   memberInsert
	   CREATE TABLE USERINFO(
	   ID VARCHAR2(50) PRIMARY KEY,   
	   PWD VARCHAR2(50) NOT NULL,   
	   NAME VARCHAR2(50) NOT NULL, 
	   EMAIL VARCHAR2(50) UNIQUE,  
	   PHONE VARCHAR2(50) NOT NULL,   
	   GENDER VARCHAR2(50) NOT NULL,
	   AGE NUMBER(3) NOT NULL,   
	   ADDRESS VARCHAR2(100), 
	   ETC VARCHAR2(3000),
	   POINT NUMBER(10),
	   AUTH NUMBER(1) NOT NULL
	);	
*/
	public boolean memberInsert(memberDTO dto);  // 회원가입
	public boolean memberLogin(String id, String pwd);   // 로그인
	public boolean idchk(String id);
	
}
