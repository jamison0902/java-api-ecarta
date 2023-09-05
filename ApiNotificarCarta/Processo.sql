CREATE TABLE IF NOT EXISTS public.processo
(
    id bigint NOT NULL,
    bairro character varying(255) COLLATE pg_catalog."default",
    cep character varying(255) COLLATE pg_catalog."default",
    complemento character varying(255) COLLATE pg_catalog."default",
    documento character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    localidade character varying(255) COLLATE pg_catalog."default",
    logradouro character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    notificado boolean NOT NULL,
    numero_processo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    uf character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT processo_pkey PRIMARY KEY (id),
    CONSTRAINT uk_6364khrxllrnv49f90tu3ub6i UNIQUE (documento),
    CONSTRAINT uk_f2ota5pu8sv0fxrrcjgorsurp UNIQUE (numero_processo)
)