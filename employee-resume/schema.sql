CREATE TABLE public.employees
(
    id serial NOT NULL,
    employee_name character varying NOT NULL,
    surname character varying NOT NULL,
    department character varying NOT NULL,
    salary integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.employees
    OWNER to postgres;