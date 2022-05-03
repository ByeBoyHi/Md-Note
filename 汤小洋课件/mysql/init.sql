drop database if exists test;
create database test charset utf8;
use test;

create table BONUS
(
  ENAME VARCHAR(10),
  JOB   VARCHAR(9),
  SAL   int,
  COMM  int
) engine=InnoDB default charset=utf8;

create table DEPT
(
  DEPTNO int(2) not null,
  DNAME  VARCHAR(14),
  LOC    VARCHAR(13)
) engine=InnoDB default charset=utf8;

create table EMP
(
  EMPNO    int(4) not null,
  ENAME    VARCHAR(10),
  JOB      VARCHAR(9),
  MGR      int(4),
  HIREDATE DATE,
  SAL      double,
  COMM     int(7),
  DEPTNO   int(2)
) engine=InnoDB default charset=utf8;

create table SALGRADE
(
  GRADE int,
  LOSAL int,
  HISAL int
) engine=InnoDB default charset=utf8;



insert into DEPT (DEPTNO, DNAME, LOC)
values (10, 'ACCOUNTING', 'NEW YORK');
insert into DEPT (DEPTNO, DNAME, LOC)
values (20, 'RESEARCH', 'DALLAS');
insert into DEPT (DEPTNO, DNAME, LOC)
values (30, 'SALES', 'CHICAGO');
insert into DEPT (DEPTNO, DNAME, LOC)
values (40, 'OPERATIONS', 'BOSTON');
commit;

insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7369, 'SMITH', 'CLERK', 7902, '19800608', 800, null, 20);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7499, 'ALLEN', 'SALESMAN', 7698, '19810605',1600, 300, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7521, 'WARD', 'SALESMAN', 7698, '19830608',  1250, 500, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7566, 'JONES', 'MANAGER', 7839, '19810608',  2975, null, 20);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7654, 'MARTIN', 'SALESMAN', 7698, '19860608',  1250, 1400, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7698, 'BLAKE', 'MANAGER', 7839, '19880608',  2850, null, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7782, 'CLARK', 'MANAGER', 7839, '19890603', 2450, null, 10);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7788, 'SCOTT', 'ANALYST', 7566, '19870602',  3000, null, 20);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7839, 'KING', 'PRESIDENT', null, '19810618',  5000, null, 10);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7844, 'TURNER', 'SALESMAN', 7698, '19820628', 1500, 0, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7876, 'ADAMS', 'CLERK', 7788, '19870628', 1100, null, 20);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7900, 'JAMES', 'CLERK', 7698, '19810608', 950, null, 30);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7902, 'FORD', 'ANALYST', 7566, '19820308', 3000, null, 20);
insert into EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
values (7934, 'MILLER', 'CLERK', 7782, '19820316',  1300, null, 10);
commit;
insert into SALGRADE (GRADE, LOSAL, HISAL)
values (1, 700, 1200);
insert into SALGRADE (GRADE, LOSAL, HISAL)
values (2, 1201, 1400);
insert into SALGRADE (GRADE, LOSAL, HISAL)
values (3, 1401, 2000);
insert into SALGRADE (GRADE, LOSAL, HISAL)
values (4, 2001, 3000);
insert into SALGRADE (GRADE, LOSAL, HISAL)
values (5, 3001, 9999);
commit;

