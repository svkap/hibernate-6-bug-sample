create sequence IF NOT EXISTS item_id_seq start 1 increment 50;
create sequence IF NOT EXISTS item_2_id_seq start 1 increment 50;
create sequence IF NOT EXISTS item_3_id_seq start 1 increment 50;

DROP TYPE IF EXISTS item_status CASCADE;
CREATE TYPE item_status AS ENUM ('STATUS_ONE', 'STATUS_TWO', 'STATUS_THREE');
create CAST (varchar AS item_status) WITH INOUT AS IMPLICIT;

DROP TYPE IF EXISTS item_type CASCADE;
CREATE TYPE item_type AS ENUM ('TYPE_ONE', 'TYPE_TWO', 'TYPE_THREE');
create CAST (varchar AS item_type) WITH INOUT AS IMPLICIT;

CREATE TABLE public.item (
          id int8 NOT NULL,
          amount numeric(33, 18) NULL,
          status public.item_status NOT NULL,
          "type" public.item_type NOT NULL,
          active bool NOT NULL,
          items_count int8 NOT NULL,
          notes varchar(255) NULL,
          created_on timestamp NOT NULL,
          updated_on timestamp NULL,
          "version" int4 NOT NULL,
          CONSTRAINT item_pk PRIMARY KEY (id)
);

insert into public.item(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
    values (nextval('item_id_seq'), 1, 'STATUS_ONE', 'TYPE_ONE', true, 1, 'Note 1', '2023-02-27 10:00:00.000000', now(), 0);
insert into public.item(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
    values (nextval('item_id_seq'), 2, 'STATUS_TWO', 'TYPE_TWO', true, 1, 'Note 2', '2023-02-27 10:00:00.000000', now(), 0);

CREATE TABLE public.item_2 (
                             id int8 NOT NULL,
                             amount numeric(33, 18) NULL,
                             status varchar(255) NOT NULL,
                             "type" varchar(255) NOT NULL,
                             active bool NOT NULL,
                             items_count int8 NOT NULL,
                             notes varchar(255) NULL,
                             created_on timestamp NOT NULL,
                             updated_on timestamp NULL,
                             "version" int4 NOT NULL,
                             CONSTRAINT item_2_pk PRIMARY KEY (id)
);

insert into public.item_2(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
values (nextval('item_2_id_seq'), 1, 'STATUS_ONE', 'TYPE_ONE', true, 1, 'Note 1', '2023-02-27 10:00:00.000000', now(), 0);
insert into public.item_2(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
values (nextval('item_2_id_seq'), 2, 'STATUS_TWO', 'TYPE_TWO', true, 1, 'Note 2', '2023-02-27 10:00:00.000000', now(), 0);

CREATE TABLE public.item_3 (
                               id int8 NOT NULL,
                               amount numeric(33, 18) NULL,
                               status int8 NOT NULL,
                               "type" int8 NOT NULL,
                               active bool NOT NULL,
                               items_count int8 NOT NULL,
                               notes varchar(255) NULL,
                               created_on timestamp NOT NULL,
                               updated_on timestamp NULL,
                               "version" int4 NOT NULL,
                               CONSTRAINT item_3_pk PRIMARY KEY (id)
);

insert into public.item_3(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
values (nextval('item_3_id_seq'), 1, 1, 1, true, 1, 'Note 1', '2023-02-27 10:00:00.000000', now(), 0);
insert into public.item_3(id, amount, status, type, active, items_count, notes, created_on, updated_on, version)
values (nextval('item_3_id_seq'), 2, 10, 10, true, 1, 'Note 2', '2023-02-27 10:00:00.000000', now(), 0);

