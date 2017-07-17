DROP TABLE IF EXISTS GroupList, Lessons, Groups, Marks, Students, Specialities, Faculties, Disciplines, Teachers, Posts, GroupTypes, LessonTypes;

CREATE TABLE Students (
  id        INT          NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(255) NOT NULL,
  lastName  VARCHAR(255) NOT NULL,
  admission DATE         NOT NULL, /*дата поступления*/
  expulsion DATE, /*дата отчисления*/

  PRIMARY KEY (id)
);

CREATE TABLE GroupTypes (
  id        INT          NOT NULL AUTO_INCREMENT,
  groupType VARCHAR(255) NOT NULL, /*тип (бакалавриат, магистратура, специалитет)*/

  PRIMARY KEY (id),
  UNIQUE KEY (groupType)
);

CREATE TABLE Faculties (
  id   INT          NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE KEY (name)
);

CREATE TABLE Specialities (
  id        INT          NOT NULL AUTO_INCREMENT,
  name      VARCHAR(255) NOT NULL,
  facultyId INT          NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (facultyId) REFERENCES Faculties (id)  /* */
);

CREATE TABLE Groups (
  id           INT     NOT NULL AUTO_INCREMENT,
  course       INT     NOT NULL, /*номер курса*/
  specialityId INT     NOT NULL,
  typeId       INT     NOT NULL,
  fulltime     BOOLEAN NOT NULL, /*очная ли группа*/
  creationDate DATE    NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (typeId) REFERENCES GroupTypes (id)  /* */,
  FOREIGN KEY (specialityId) REFERENCES Specialities (id)  /* */
);

CREATE TABLE GroupList (
  id        INT NOT NULL AUTO_INCREMENT,
  studentId INT NOT NULL,
  groupId   INT NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (studentId) REFERENCES Students (id)    /* */,
  FOREIGN KEY (groupId) REFERENCES Groups (id)    /* */
);

CREATE TABLE Disciplines (
  id   INT          NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,

  PRIMARY KEY (id),
  UNIQUE KEY (name)
);

CREATE TABLE Posts (
  id   INT          NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE Teachers (
  id        INT          NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(255) NOT NULL,
  lastName  VARCHAR(255) NOT NULL,
  postId    INT          NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (postId) REFERENCES Posts (id)
);

CREATE TABLE LessonTypes (
  id         INT          NOT NULL AUTO_INCREMENT,
  lessonType VARCHAR(255) NOT NULL, /*семинар, практика и тд*/

  PRIMARY KEY (id),
  UNIQUE KEY (lessonType)
);

CREATE TABLE Lessons (
  id           INT NOT NULL AUTO_INCREMENT,
  typeId       INT NOT NULL,
  disciplineId INT NOT NULL,
  groupId      INT NOT NULL,
  teacherId    INT NOT NULL,
  hours        INT NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (typeId) REFERENCES LessonTypes (id)  /* */,
  FOREIGN KEY (disciplineId) REFERENCES Disciplines (id)  /* */,
  FOREIGN KEY (groupId) REFERENCES Groups (id)    /* */,
  FOREIGN KEY (teacherId) REFERENCES Teachers (id)    /* */
);

CREATE TABLE Marks (
  id           INT  NOT NULL AUTO_INCREMENT,
  markTime     DATE NOT NULL,
  mark         INT  NOT NULL,
  disciplineId INT  NOT NULL,
  teacherId    INT  NOT NULL,
  studentId    INT  NOT NULL,

  PRIMARY KEY (id),
  FOREIGN KEY (disciplineId) REFERENCES Disciplines (id)  /* */,
  FOREIGN KEY (teacherId) REFERENCES Teachers (id)    /* */,
  FOREIGN KEY (studentId) REFERENCES Students (id)    /* */
);