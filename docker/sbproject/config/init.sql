create table persons
(
    id         bigserial constraint persons_pk primary key,
    name       varchar(20) not null,
    age        integer     not null,
    created_by bigint      not null,
    created_at timestamp   not null,
    updated_by integer     not null,
    updated_at timestamp   not null,
    deleted boolean default false,
    deleted_by bigint      ,
    deleted_at timestamp
);

alter table persons owner to sbproject;

INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (1, '홍길동', 20, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (2, '손흥민', 25, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (3, '김연아', 26, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (4, '양세형', 35, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (5, '유재석', 50, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (6, '조세호', 42, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (7, '김두호', 33, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (8, '안정환', 45, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (9, '박지성', 44, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (10, '호날두', 39, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (11, '김덕배', 32, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (12, '김민재', 33, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (13, '이강인', 29, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (14, '황희찬', 31, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (15, '설기현', 47, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (16, '김남일', 43, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (17, '양민혁', 19, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (18, '백승호', 27, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (19, '이승우', 28, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (20, '배준호', 29, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (21, '감자깡', 40, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.persons (id, name, age, created_by, created_at, updated_by, updated_at) VALUES (22, '안세영', 23, 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');

create table dept
(
    deptno     bigserial constraint dept_pk primary key,
    dname      varchar(20) not null,
    loc        varchar(20) not null,
    created_by bigint      not null,
    created_at timestamp   not null,
    updated_by integer     ,][]
    updated_at timestamp   not null,
    deleted boolean default false,
    deleted_by bigint      ,
    deleted_at timestamp
);

alter table dept owner to sbproject;

INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (1, 'ACCOUNTING', 'NEWYORK', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (2, 'RESEARCH', 'DALLAS', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (3, 'SALES', 'CHICAGO', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (4, 'OPERATIONS', 'BOSTON', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (5, 'MARKETING', 'SAN_FRANCISCO', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (6, 'CUSTOMER_SERVICE', 'LOS_ANGELES', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (7, 'PROCUREMENT', 'MIAMI', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (8, 'LEGAL', 'SEATTLE', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (9, 'ADMINISTRATION', 'DENVER', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (10, 'HR', 'ATLANTA', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (11, 'LOGISTICS', 'HOUSTON', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (12, 'ENGINEERING', 'PHILADELPHIA', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (13, 'QUALITY_CONTROL', 'SAN_DIEGO', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (14, 'CONSULTING', 'AUSTIN', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (15, 'PRODUCT_DEVELOPMENT', 'PHOENIX', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (16, 'PUBLIC_RELATIONS', 'CHARLOTTE', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (17, 'TRAINING', 'ORLANDO', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');
INSERT INTO public.dept (deptno, dname, loc, created_by, created_at, updated_by, updated_at) VALUES (18, 'RISK_MANAGEMENT', 'MINNEAPOLIS', 1, '2024-08-12 01:41:25.503312', 1, '2024-08-12 01:41:25.503312');