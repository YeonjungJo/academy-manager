create table courses (
  courseId bigint auto_increment comment 'PRIMARY KEY' primary key,
  engHour int comment '영어강의시간',
  mathHour int comment '수학강의시간',
  discussionHour int comment '토론강의시간',
  price bigint comment '수강료'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
