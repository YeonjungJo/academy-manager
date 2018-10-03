create table rooms (
	roomId bigint auto_increment comment 'PRIMARY KEY' primary key,
	name varchar(10) not null comment '이름',
	status varchar(20) default 'ACTIVE' not null comment '상태'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table students (
	studentId bigint auto_increment comment 'PRIMARY KEY' primary key,
	userId bigint not null comment 'USER ID(FK)',
	school varchar(20) null comment '학교',
	schoolYear varchar(20) not null comment '학년',
	parentPhoneNumber varchar(20) null comment '부모님번호'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table users (
	userId bigint auto_increment comment 'PRIMARY KEY' primary key,
	loginId varchar(40) not null comment '로그인아이디',
	password varchar(80) not null comment '비밀번호',
	name varchar(10) not null comment '이름',
	gender varchar(20) not null comment '성별',
	phoneNumber varchar(20) null comment '번호',
	email varchar(50) null comment '이메일',
	role varchar(80) default 'GUEST' not null comment '역할',
	status varchar(20) default 'READY' not null comment '상태',
	createdAt datetime(6) not null comment '생성일',
	grantedAt datetime(6) not null comment '권한부여일',
	address varchar(150) null,
	birth date null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;