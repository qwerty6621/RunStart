package BbsList;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

public interface iBbsList {
/*
 CREATE TABLE QABOARD(
   SEQ NUMBER(8) PRIMARY KEY,
   ID VARCHAR2(100) NOT NULL,
   
   REF NUMBER(8) NOT NULL,         
   STEP NUMBER(8) NOT NULL,   
   DEPTH NUMBER(8) NOT NULL,    
   
   qaType varchar2(200) not null,
   TITLE VARCHAR2(2000) NOT NULL,
   CONTENT VARCHAR2(4000) NOT NULL,
   WDATE DATE NOT NULL,
   PARENT NUMBER(8) NOT NULL,      
   
   image varchar2(4000),
   
   DEL NUMBER(1) NOT NULL,      
   READCOUNT NUMBER(8) NOT NULL   
);

CREATE SEQUENCE SEQ_QABOARD
START WITH 1
INCREMENT BY 1;
 
 
 SELECT SEQ, ID, REF, STEP, DEPTH, QATYPE, TITLE, CONTENT, WDATE, PARENT, IMAGE, DEL, READCOUNT 
FROM QABOARD
ORDER BY REF DESC, STEP ASC;
 
 q11
commit;

INSERT INTO QABOARD(SEQ, ID, REF, STEP, DEPTH, QATYPE, TITLE, CONTENT, WDATE, PARENT, IMAGE, DEL, READCOUNT)
VALUES(SEQ_QABOARD.nextval, 'ID', 0,0,0, '정형외', '의학품에 대해서 궁금합니다.', '제가궁금한게있습니다. 의약품 이것이 궁금한데 맞습니까', SYSDATE, 0, '1', 0, 443); 
 */
	
	
	public List<BbsDTO> getBbsList(String searchWord, String choice);   // bbs.jsp 게시물 리스트 가져오기
	public boolean BbsInsert(String id, String title, String content, String qnatype, String image);  // bbs.insert 게시물 작성
	public BbsDTO getBbsSelect(int seq);   // 게시물 읽기
	public String getFileSelect(String seq);  // 파일명 뽑아오기 게시물 수정을 위한 작업.
	public boolean BbsUpdate(String seq, String id, String qnatype, String title, String content, String all);  // 게시물 수정을 위한 

  
}
