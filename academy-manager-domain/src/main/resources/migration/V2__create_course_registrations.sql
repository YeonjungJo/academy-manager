create table courses(
  courseId bigint auto_increment comment 'PRIMARY KEY' primary key,
  courseName varchar(100) not null comment '이름',
  price bigint not null comment '수강료',
  enableStatus varchar(100) default 'ACTIVE',
  schoolType varchar(100) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

create table course_compositions (
  courseCompositionId bigint auto_increment comment 'PRIMARY KEY' primary key,
  subject varchar(100) not null comment '과목',
  time int not null comment '강의시간',
  courseId bigint not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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

INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (1, '초등단과(수학)', 190000, 'ACTIVE', 'ELEMENTARY');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (2, '초등종합', 320000, 'ACTIVE', 'ELEMENTARY');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (3, '중등단과(수학)', 240000, 'ACTIVE', 'MIDDLE');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (4, '중등종합', 430000, 'ACTIVE', 'MIDDLE');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (5, '고등단과(수학)', 300000, 'ACTIVE', 'HIGH');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (6, '고등종합', 560000, 'ACTIVE', 'HIGH');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (7, '초등단과(영어)', 190000, 'ACTIVE', 'ELEMENTARY');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (8, '중등단과(영어)', 240000, 'ACTIVE', 'MIDDLE');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (9, '고등단과(영어)', 300000, 'ACTIVE', 'HIGH');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (10, '토론 주1', 100000, 'ACTIVE', 'HIGH');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (11, '토론 주2', 190000, 'ACTIVE', 'HIGH');
INSERT INTO academy_manager.courses (courseId, courseName, price, enableStatus, schoolType) VALUES (12, '토론 주3', 280000, 'ACTIVE', 'HIGH');

INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (1, 'MATH', 5, 1);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (2, 'MATH', 5, 2);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (3, 'MATH', 5, 3);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (4, 'MATH', 5, 4);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (5, 'MATH', 5, 5);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (6, 'MATH', 5, 6);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (7, 'DISCUSS', 1, 10);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (8, 'DISCUSS', 2, 11);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (9, 'DISCUSS', 3, 12);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (10, 'ENGLISH', 5, 2);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (11, 'ENGLISH', 5, 4);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (12, 'ENGLISH', 5, 6);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (13, 'ENGLISH', 5, 7);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (14, 'ENGLISH', 5, 8);
INSERT INTO academy_manager.course_compositions (courseCompositionId, subject, time, courseId) VALUES (15, 'ENGLISH', 5, 9);

INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (1, 1, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (2, 2, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (3, 3, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (4, 4, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (5, 5, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (6, 6, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (7, 7, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (8, 8, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (9, 9, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (10, 10, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (11, 11, 1, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (12, 12, 2, '2018-10-17');
INSERT INTO academy_manager.course_registrations (courseRegistrationId, studentId, courseId, registrationDate) VALUES (13, 13, 4, '2018-10-17');