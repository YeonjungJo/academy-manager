create table course_registrations (
  courseRegistrationId bigint auto_increment comment 'PRIMARY KEY' primary key,
  studentId bigint not null comment 'studentId',
  courseId int not null comment 'courseId',
  registrationDate date not null comment '등록일자'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table course_registration_log (
  courseRegistrationLogId bigint auto_increment comment 'PRIMARY KEY' primary key,
  studentId bigint not null comment 'studentId',
  courseId int not null comment 'courseId',
  registrationDate date not null comment '등록일자',
  description varchar(150) comment '설명'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;