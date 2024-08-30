-- 2024.08.27 member 추가 by 김진수
create table member
(
    seq_no        bigserial constraint members_pk primary key,ㅊㅌ
    username      varchar   not null constraint member_user_name_uk unique,
    password      varchar   not null,
    refresh_token varchar,
    created_by    bigint    not null,
    created_at    timestamp not null,
    updated_by    integer   not null,
    updated_at    timestamp not null,
    deleted       boolean default false,
    deleted_by    bigint,
    deleted_at    timestamp
);
alter table member owner to llmops;

INSERT INTO public.member (seq_no, username, password, refresh_token, created_by, created_at, updated_by, updated_at, deleted, deleted_by, deleted_at) VALUES (DEFAULT, 'test', 'test', null, 1, '2024-08-27 11:49:25.000000', 1, '2024-08-27 11:49:25.000000', false, null, null);

create table member_role
(
    seq_no        bigserial constraint members_roles_pk primary key,
    member_seq_no bigint    not null constraint member_role_member_seq_no_fk references member,
    role          varchar   not null,
    created_by    bigint    not null,
    created_at    timestamp not null
);

alter table member_role owner to llmops;

INSERT INTO public.member_role ( member_seq_no, role, created_by, created_at) VALUES ( 1, 'USER', 1, '2024-08-27 11:49:45.000000')