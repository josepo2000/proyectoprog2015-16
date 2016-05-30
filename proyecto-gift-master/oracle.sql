
DROP TABLE CATEGORIA CASCADE CONSTRAINTS;

CREATE TABLE CATEGORIA(
NOMBRE VARCHAR2(16),
TIPO VARCHAR2(16),
CONSTRAINT CAT_PK PRIMARY KEY (NOMBRE)
);


COMMIT;



DROP TABLE PREGUNTA CASCADE CONSTRAINTS;


CREATE TABLE PREGUNTA(
ENUNCIADO VARCHAR(70),
NOMBRE_CATEGORIA VARCHAR(16),
CONSTRAINT PRE_PK PRIMARY KEY (ENUNCIADO),
CONSTRAINT NOM_CAT_FK FOREIGN KEY (NOMBRE_CATEGORIA)
				REFERENCES CATEGORIA(NOMBRE) ON DELETE CASCADE);


COMMIT;


DROP TABLE RESPUESTA CASCADE CONSTRAINTS;

CREATE TABLE RESPUESTA(
ENUNCIADO VARCHAR2(14),
SOLUCION NUMBER(1),
ENUN_PRE VARCHAR(70),
CONSTRAINT RESP_PK PRIMARY KEY (ENUNCIADO) ,
CONSTRAINT ENUN_PRE_FK  FOREIGN KEY (ENUN_PRE)
				REFERENCES PREGUNTA(ENUNCIADO) ON DELETE CASCADE);


COMMIT;




