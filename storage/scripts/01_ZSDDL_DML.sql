-- database: ..\Databases\ZSEXOBOT.sqlite
-- © 2K26 ❱──👾──❰ c_bit

DROP TABLE IF EXISTS ZSSexo;
DROP TABLE IF EXISTS ZSSoldado;
DROP TABLE IF EXISTS ZSExobotTipo;
DROP TABLE IF EXISTS ZSExobot;
DROP TABLE IF EXISTS ZSArmaTipo;

CREATE TABLE ZSSexo(
     IdZSSexo             INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ZSNombre             VARCHAR(10) NOT NULL UNIQUE
    ,ZSDescripcion        VARHCAR (30) NOT NULL
    ,ZSEstado             VARCHAR(1) NOT NULL DEFAULT ('A')
    ,ZSFechaCreacion      DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,ZSFechaModificacion  DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

-- Refactorización: Se eliminaron los campos ZSNombre y ZSApellido. Además, se cambió ZSCedula por ZSUsuario
CREATE TABLE ZSSoldado(
     IdZSSoldado            INTEGER NOT NULL PRIMARY  KEY AUTOINCREMENT
    ,IdZSSexo               INTEGER NOT NULL REFERENCES ZSSexo (IdZSSexo)
    ,ZSUsuario              VARCHAR(10) NOT NULL UNIQUE 
    ,ZSContrasena           VARCHAR(10) NOT NULL UNIQUE 
    ,ZSEstado               VARCHAR(1) NOT NULL DEFAULT ('A')
    ,ZSFechaCreacion        DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,ZSFechaModificacion    DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSExobotTipo(
     IdZSExobotTipo            INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ZSNombre                  VARCHAR(10) NOT NULL
    ,ZSDescripcion             VARCHAR(30) NOT NULL
    ,ZSEstado                  VARCHAR(1) NOT NULL DEFAULT ('A') 
    ,ZSFechaCreacion           DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,ZSFechaModificacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSArmaTipo(
     IdZSArmaTipo           INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,ZSNombre                  VARCHAR(10) NOT NULL UNIQUE
    ,ZSDescripcion             VARCHAR(30) NOT NULL
    ,ZSEstado                  VARCHAR(1) NOT NULL DEFAULT ('A') 
    ,ZSFechaCreacion           DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,ZSFechaModificacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);

-- Refactorización: Se eliminó el campo ZSArmaTipo de la tabla ZSExobot
CREATE TABLE ZSExobot(
     IdZSExobot                INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdZSExobotTipo            INTEGER NOT NULL REFERENCES ZSExobotTipo(IdZSExobotTipo)
    ,ZSEstado                  VARCHAR(1) NOT NULL DEFAULT ('A')
    ,ZSEntreno                 VARCHAR(2) NOT NULL DEFAULT ('NO')
    ,ZSNoAccion                INTEGER NOT NULL 
    ,ZSFechaCreacion           DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
    ,ZSFechaModificacion       DATETIME NOT NULL DEFAULT (datetime('now','localtime'))
);
INSERT INTO ZSSexo (zsNombre, zsDescripcion) VALUES
    ('Hombre' , 'Sexo masculino')
   ,('Mujer'  , 'Sexo femenino')
   ,('Híbrido','Mezcla de ambos sexos');

INSERT INTO ZSSoldado (IdZSSexo, ZSUsuario, ZSContrasena) VALUES 
    (1,'patmic'    , '123')
   ,(1,'1727915942', '2801');

INSERT INTO ZSExobotTipo (ZSNombre, ZSDescripcion) VALUES
    ('ExoAsalto'    ,  'Exobot de ataque y usa municiones')
   ,('ExoExplorador',  'Exobot de exploración y detecta energía')
   ,('ExoInfanteria',  'Exobot de infantería y usa municiones')
   ,('ExoMedico'    ,  'Exobot que asiste con energía')
   ,('ExoComando'   ,  'Exobot de comando que usa municiones');

INSERT INTO ZSArmaTipo (ZSNombre, ZSDescripcion) VALUES 
    ('Fusil'   ,'Arma de ataque usada por ExoAsalto')
   ,('Revolver','Arma de ataque usada por ExoAsalto');

INSERT INTO ZSExobot (IdZSExobotTipo, ZSEntreno, ZSNoAccion) VALUES
    (3, 'SI', 22)
   ,(1, 'NO', 0 )
   ,(3, 'NO', 0 )
   ,(4, 'NO', 0 );





