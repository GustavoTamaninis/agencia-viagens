CREATE TABLE public.app_user(
    id bigserial NOT NULL,
    username varchar(50) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    CONSTRAINT app_user_pkey PRIMARY KEY (id),
    CONSTRAINT app_user_username_key UNIQUE (username),
    CONSTRAINT app_user_email_key UNIQUE (email)
);