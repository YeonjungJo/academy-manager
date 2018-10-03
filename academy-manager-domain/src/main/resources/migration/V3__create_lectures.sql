create table courses (
  courseId bigint auto_increment comment 'PRIMARY KEY' primary key,
  courseName varchar(100) comment '이름',
  price bigint comment '수강료'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table course_compositions (
  courseCompositionId bigint auto_increment comment 'PRIMARY KEY' primary key,
  subject varchar(100) comment '과목',
  time int comment '강의시간'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;