---------
--users--
---------

--테이블 생성
create table users(
  id VARCHAR2(45)
    constraint users_id_pk primary key,                -- 아이디
  username VARCHAR2(45),                               -- 이름
  email VARCHAR2(45),                                  -- 이메일
  nickname VARCHAR2(45),                               -- 별명
  sns_name VARCHAR2(45)
    check(gender in('naver', 'kakao', 'google')),      -- sns
  create_date TIMESTAMP,                               -- 생성일
  modify_date TIMESTAMP                                -- 수정일 
);