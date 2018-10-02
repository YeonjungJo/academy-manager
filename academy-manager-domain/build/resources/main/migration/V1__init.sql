create table attendees
(
  attendeeId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  courseId bigint not null comment '강의ID',
  studentId bigint not null comment '학생ID',
  status varchar(20) default 'READY' not null comment '수강상태'
)
;

create table courses
(
  courseId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  subject varchar(10) not null comment '과목명',
  name varchar(20) not null comment '강의명',
  status varchar(20) default 'READY' not null comment '강의상태'
)
;

create index courses_idx01
  on courses (subject, status)
;

create table rooms
(
  roomId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  name varchar(10) not null comment '이름',
  status varchar(20) default 'ACTIVE' not null comment '상태'
)
;

create table students
(
  studentId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  userId bigint not null comment 'USER ID(FK)',
  gender varchar(20) not null comment '성별',
  birth datetime(6) not null comment '생년월일',
  school varchar(20) null comment '학교',
  schoolYear varchar(20) not null comment '학년',
  parentPhoneNumber varchar(20) null comment '부모님번호',
  address varchar(120) null comment '주소'
)
;

create table teachers
(
  teacherId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  userId bigint not null comment 'USER ID(FK)',
  subject varchar(100) not null comment '담당과목'
)
;

create index teachers_idx01
  on teachers (subject)
;

create table users
(
  userId bigint auto_increment comment 'PRIMARY KEY'
    primary key,
  loginId varchar(40) not null comment '로그인아이디',
  password varchar(80) not null comment '비밀번호',
  name varchar(10) not null comment '이름',
  gender varchar(20) not null comment '성별',
  phoneNumber varchar(20) null comment '번호',
  email varchar(50) null comment '이메일',
  role varchar(80) default 'GUEST' not null comment '역할',
  status varchar(20) default 'READY' not null comment '상태',
  createdAt datetime(6) not null comment '생성일',
  grantedAt datetime(6) not null comment '권한부여일'
)
;

create index users_idx01
  on users (loginId, password)
;

