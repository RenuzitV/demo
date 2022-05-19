drop table if exists quiz cascade;
drop table if exists question cascade;
drop table if exists answer cascade;

create table if not exists quiz
(
    id   bigint not null
        primary key,
    date date,
    name varchar(255)
);

create table if not exists question
(
    id      bigint not null
        primary key,
    content varchar(255),
    quiz_id bigint
        constraint fkb0yh0c1qaxfwlcnwo9dms2txf
            references quiz
);

create table if not exists answer
(
    id                bigint  not null
        primary key,
    content           varchar(255),
    is_correct_answer boolean not null,
    question_id       bigint
        constraint fk8frr4bcabmmeyyu60qt7iiblo
            references question
);

alter table quiz
    owner to postgres;

alter table answer
    owner to postgres;

alter table question
    owner to postgres;

INSERT INTO public.quiz (id, date, name) VALUES (2, '2022-05-13', 'final test');
INSERT INTO public.quiz (id, date, name) VALUES (6, '2022-01-11', 'mid semester test');
INSERT INTO public.quiz (id, date, name) VALUES (10, '2010-05-20', 'entry level test');
INSERT INTO public.quiz (id, date, name) VALUES (14, '2022-05-21', 'universal level quiz');
INSERT INTO public.quiz (id, date, name) VALUES (18, '2022-05-22', 'first year uni level quiz');
INSERT INTO public.question (id, content, quiz_id) VALUES (1, 'is javascript java with scripts?', 2);
INSERT INTO public.question (id, content, quiz_id) VALUES (5, 'is the creator of this final test handsome?', 6);
INSERT INTO public.question (id, content, quiz_id) VALUES (9, 'will this student get full marks for this test?', 10);
INSERT INTO public.question (id, content, quiz_id) VALUES (13, 'will the universe go to a heat death?', 14);
INSERT INTO public.question (id, content, quiz_id) VALUES (17, 'is copy and pasting the same lines of code over and over bad?', 18);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (3, 'No', true, 1);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (4, 'Yes', false, 1);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (7, 'Yes', true, 5);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (8, 'No', false, 5);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (11, 'No', true, 9);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (12, 'Yes', false, 9);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (15, 'Yes', true, 13);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (16, 'No', false, 13);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (19, 'Yes', true, 17);
INSERT INTO public.answer (id, content, is_correct_answer, question_id) VALUES (20, 'No', false, 17);