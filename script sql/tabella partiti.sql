CREATE DATABASE PARTITO
USE PARTITO
GO



create table PARTITI(
	NOME_PARTITO VARCHAR(40) primary key,
	CANDIDATO_0 VARCHAR(30),
	CANDIDATO_1 VARCHAR(30),
	CANDIDATO_2 VARCHAR(30),
	NUM_VOTI_COMPLESSIVI INT,
	VOTI_CAND_0 INT,
	VOTI_CAND_1 INT,
	VOTI_CAND_2 INT
)
 

INSERT INTO PARTITI VALUES('Liga Veneta Repubblica','RIVA GIGI', 'MEAZZA GIUSEPPE', 'PIOLA SILVIO',0,0,0,0);
INSERT INTO PARTITI VALUES('Esseritari','BAGGIO ROBERTO', 'DEL PIERO ALESSANDRO', 'ALTOBELLI ALESSANDRO',0,0,0,0);
INSERT INTO PARTITI VALUES('Stati Uniti d''Europa','BALONCIERI ADOLFO', 'INZAGHI FILIPPO', 'GRAZIANI FRANCESCO',0,0,0,0);
INSERT INTO PARTITI VALUES('Gilet arancioni - Si cambia musica','VIERI CHRISTIAN', 'MAZZOLA SANDRO', 'DE ROSSI DANIELE',0,0,0,0);
INSERT INTO PARTITI VALUES('Fronte Verde','ROSSI PAOLO', 'BETTEGA ROBERTO', 'GILARDINO ALBERTO',0,0,0,0);
INSERT INTO PARTITI VALUES('PPA - Popolo delle Partite Iva','TONI LUCA', 'VIALLI GIANLUCA', 'COLAUSSI GINO',0,0,0,0);
INSERT INTO PARTITI VALUES('Movimento Poeti d''Azione','LIBONATTI JULIO', 'SCHIAVIO ANGELO', 'FERRARI GIOVANNI',0,0,0,0);
INSERT INTO PARTITI VALUES('La Catena','RIVERA GIANNI', 'BALOTELLI MARIO', 'CASIRAGHI PIERLUIGI',0,0,0,0);
INSERT INTO PARTITI VALUES('Sacro Romano Impero Cattolico','MAGNOZZI MARIO', 'ORSI RAIMUNDO', 'PIRLO ANDREA',0,0,0,0);
INSERT INTO PARTITI VALUES('Partito internettiano','CEVENINI LUIGI', 'DI NATALE ANTONIO', 'LEVRATTO VIRGILIO FELICE',0,0,0,0);
INSERT INTO PARTITI VALUES('Ora rispetto per tutti gli animali','CARAPELLESE RICCARDO', 'CASSANO ANTONIO', 'ZOLA GIANFRANCO',0,0,0,0);

select * from PARTITI


drop table partiti

