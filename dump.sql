--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

ALTER TABLE ONLY public.tblemployee DROP CONSTRAINT fk_jxiu9db9xkrlbtfwi1df0ypfa;
ALTER TABLE ONLY public.tblemployee DROP CONSTRAINT uk_d1a1cixljc7p8o6a0yetdptgo;
ALTER TABLE ONLY public.tblusers DROP CONSTRAINT uk_93fcc4u4l2wl9ymts01mkutng;
ALTER TABLE ONLY public.tblusers DROP CONSTRAINT tblusers_pkey;
ALTER TABLE ONLY public.tblemployee DROP CONSTRAINT tblemployee_pkey;
DROP TABLE public.tblusers;
DROP TABLE public.tblemployee;
DROP EXTENSION plpgsql;
DROP SCHEMA public;
--
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tblemployee; Type: TABLE; Schema: public; Owner: webadmin; Tablespace: 
--

CREATE TABLE tblemployee (
    id character varying(255) NOT NULL,
    address character varying(255),
    email character varying(100),
    full_name character varying(200) NOT NULL,
    number character varying(50) NOT NULL,
    phone character varying(100),
    photo character varying(8000),
    input_by_id character varying(255) NOT NULL
);


ALTER TABLE tblemployee OWNER TO webadmin;

--
-- Name: tblusers; Type: TABLE; Schema: public; Owner: webadmin; Tablespace: 
--

CREATE TABLE tblusers (
    id character varying(255) NOT NULL,
    email character varying(200) NOT NULL,
    full_name character varying(200) NOT NULL,
    password character varying(150) NOT NULL
);


ALTER TABLE tblusers OWNER TO webadmin;

--
-- Name: tblemployee_pkey; Type: CONSTRAINT; Schema: public; Owner: webadmin; Tablespace: 
--

ALTER TABLE ONLY tblemployee
    ADD CONSTRAINT tblemployee_pkey PRIMARY KEY (id);


--
-- Name: tblusers_pkey; Type: CONSTRAINT; Schema: public; Owner: webadmin; Tablespace: 
--

ALTER TABLE ONLY tblusers
    ADD CONSTRAINT tblusers_pkey PRIMARY KEY (id);


--
-- Name: uk_93fcc4u4l2wl9ymts01mkutng; Type: CONSTRAINT; Schema: public; Owner: webadmin; Tablespace: 
--

ALTER TABLE ONLY tblusers
    ADD CONSTRAINT uk_93fcc4u4l2wl9ymts01mkutng UNIQUE (email);


--
-- Name: uk_d1a1cixljc7p8o6a0yetdptgo; Type: CONSTRAINT; Schema: public; Owner: webadmin; Tablespace: 
--

ALTER TABLE ONLY tblemployee
    ADD CONSTRAINT uk_d1a1cixljc7p8o6a0yetdptgo UNIQUE (number);


--
-- Name: fk_jxiu9db9xkrlbtfwi1df0ypfa; Type: FK CONSTRAINT; Schema: public; Owner: webadmin
--

ALTER TABLE ONLY tblemployee
    ADD CONSTRAINT fk_jxiu9db9xkrlbtfwi1df0ypfa FOREIGN KEY (input_by_id) REFERENCES tblusers(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

