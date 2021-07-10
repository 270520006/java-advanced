由于最近的面试总结，发现自己写sql的能力有所下降，处于对技术的考虑，这里准备认真复习一波sql语句。

以下是我搜集到的sql语句题目，如果有冒犯请联系我删除，我会在文章末尾加上引用地址的。



### 基本表结构

* student(sno,sname,sage,ssex)学生表
* course(cno,cname,tno) 课程表
* sc(sno,cno,score) 成绩表 
* teacher(tno,tname) 教师表*

这里给出我数据库创建语句，让大家更快的创建把：

```mysql
CREATE DATABASE /*!32312 IF NOT EXISTS*/`class_demo` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `class_demo`;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `cno` BIGINT NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(255) DEFAULT NULL,
  `tno` INT DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `course` */

INSERT  INTO `course`(`cno`,`cname`,`tno`) VALUES (1,'自然科学',1),(2,'围棋',2),(3,'高数',3);

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `sno` BIGINT NOT NULL,
  `cno` BIGINT NOT NULL,
  `score` INT DEFAULT NULL,
  PRIMARY KEY (`sno`,`cno`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb3;

/*Data for the table `sc` */

INSERT  INTO `sc`(`sno`,`cno`,`score`) VALUES (1,1,90),(1,2,75),(1,3,60),(2,1,60),(2,2,80),(2,3,77),(3,1,55),(3,2,55),(3,3,55);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sno` BIGINT NOT NULL AUTO_INCREMENT,
  `sname` VARCHAR(255) DEFAULT NULL,
  `sage` INT DEFAULT NULL,
  `ssex` INT DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `student` */

INSERT  INTO `student`(`sno`,`sname`,`sage`,`ssex`) VALUES (1,'zsp',22,1),(2,'wlx',23,1),(3,'lfl',24,0);

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `tno` BIGINT NOT NULL AUTO_INCREMENT,
  `tname` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

/*Data for the table `teacher` */

INSERT  INTO `teacher`(`tno`,`tname`) VALUES (1,'河伯'),(2,'3y'),(3,'朱少鹏');
```

 

### 题目

#### 1、查询课程1的成绩比课程2的成绩高的所有学生的学号

```MYSQL
SELECT A.SNO FROM 
(SELECT SNO,SCORE FROM SC WHERE CNO=1) A,
(SELECT SNO,SCORE FROM SC WHERE CNO=2) B
WHERE A.SNO =B.SNO AND A.SCORE>B.SCORE
```

由于mysql存在小写转大写的情况（可以自己把分表查询的A和B换成a和b，会发现结果没变），所以我全部大写了。

#### 2、查询平均成绩大于60分的同学的学号和平均成绩

```mysql
SELECT A.SNO AS "学号",AVG(A.SCORE) AS "平均成绩" FROM
(SELECT SNO,SCORE FROM SC) A
GROUP BY SNO HAVING AVG(A.SCORE)>60
```

#### 3、查询所有同学的学号、姓名、选课数、总成绩

```mysql
SELECT A.SNO AS "学号",A.SNAME AS "姓名" , COUNT(B.CNO) AS "选课数" ,SUM(B.SCORE) AS "总成绩"FROM
(SELECT SNO,SNAME FROM STUDENT ) A ,
(SELECT SNO,CNO,SCORE FROM SC ) B
WHERE A.SNO =B.SNO
GROUP BY A.SNO 
```

#### 4、查询姓“朱”的老师的个数

```mysql
 SELECT COUNT(TNAME) FROM TEACHER WHERE TNAME LIKE'朱%'
```

####  5、查询学过“朱少鹏”老师课的同学的学号、姓名

```mysql
 SELECT SNO,SNAME FROM STUDENT
 WHERE SNO  IN (SELECT DISTINCT(SC.SNO) FROM SC,COURSE,TEACHER 
 WHERE TEACHER.TNO =COURSE.TNO AND SC.CNO=COURSE.CNO AND TEACHER.TNAME='朱少鹏')
```

