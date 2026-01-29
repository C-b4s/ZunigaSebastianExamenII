-- database: ..\Databases\ZSAnt.sqlite
-- © 2K26 ❱──👾──❰ c_bit

DROP TABLE IF EXISTS ZSAntCiberDron;
DROP TABLE IF EXISTS ZSHormiga;
DROP TABLE IF EXISTS ZSAlimento;
DROP TABLE IF EXISTS ZSSexo;
DROP TABLE IF EXISTS ZSEstado;
DROP TABLE IF EXISTS ZSHormigaTipo;
DROP TABLE IF EXISTS ZSAlimentoTipo;

CREATE TABLE ZSAlimentoTipo (
     IdZSAlimentoTipo INTEGER PRIMARY KEY AUTOINCREMENT     
    ,zsNombre         VARCHAR(15) NOT NULL UNIQUE
    ,zsDescripcion    VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSHormigaTipo (
     IdZSHormigaTipo  INTEGER PRIMARY KEY AUTOINCREMENT     
    ,zsNombre         VARCHAR(15) NOT NULL UNIQUE
    ,zsDescripcion    VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSEstado (
     IdZSEstado       INTEGER PRIMARY KEY AUTOINCREMENT     
    ,zsNombre         VARCHAR(15) NOT NULL UNIQUE
    ,zsDescripcion    VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSSexo (
     IdZSSexo         INTEGER PRIMARY KEY AUTOINCREMENT
    ,zsNombre         VARCHAR(15) NOT NULL UNIQUE
    ,zsDescripcion    VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSAlimento (
     IdZSAlimento     INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdZSAlimentoTipo INTEGER NOT NULL REFERENCES ZSAlimentoTipo (IdZSAlimentoTipo)
    ,zsNombre         VARCHAR(15) NOT NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSHormiga (
     IdZSHormiga      INTEGER PRIMARY KEY AUTOINCREMENT
    ,IdZSHormigaTipo  INTEGER NOT NULL REFERENCES ZSHormigaTipo (IdZSHormigaTipo)
    ,IdZSSexo         INTEGER NOT NULL REFERENCES ZSSexo        (IdZSSexo)
    ,IdZSEstado       INTEGER NOT NULL REFERENCES ZSEstado      (IdZSEstado)
    ,zsNombre         VARCHAR(15) NOT NULL 
    ,zsDescripcion    VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE ZSAntCiberDron(
         IdZSAntCiberDron      INTEGER PRIMARY KEY AUTOINCREMENT
        ,zsSerie               VARCHAR(15) NOT NULL UNIQUE
        ,zsEstado              VARCHAR(1)  NOT NULL DEFAULT ('A')
        ,zsFechaCreacion       DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
        ,zsFechaModifica       DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);


INSERT INTO ZSSexo (zsNombre, zsDescripcion) VALUES
     ('Macho', 'Masculino')
    ,('Hembra', 'Femenina')
    ,('Híbrido', 'Hormiga con características de ambos sexos')
    ,('Asexual', 'Hormiga sin sexo definido');

INSERT INTO ZSAlimentoTipo (zsNombre, zsDescripcion) VALUES
    ('Carnivoro', 'Azucar')
   ,('Herbívoro', 'Proteina')
   ,('Omnívoro', 'Lipídico')
   ,('Nectarívoro', 'Vitamínico');

INSERT INTO ZSHormigaTipo (zsNombre, zsDescripcion) VALUES
    ('Larva', 'Hormiga en etapa de larva')
   ,('Soldado', 'Hormiga encargada de la defensa de la colonia')
   ,('Rastreadora','Hormiga encargada de buscar alimento')
   ,('Reina','Hormiga encargada de la reproducción')
   ,('Zángano','Hormiga macho para reproducción');


INSERT INTO ZSEstado (zsNombre, zsDescripcion) VALUES
     ('Vive', 'está viva')
    ,('Muere', 'ha fmuerto')
    ,('Finge','finge su muerte');

INSERT INTO ZSAntCiberDron (ZSSerie) VALUES
     ('S001')
    ,('S002')
    ,('S003')
    ,('S004');

INSERT INTO zsHormiga (
     IdZSHormigaTipo
    ,IdZSSexo
    ,IdZSEstado
    ,zsNombre
    ,zsDescripcion
) VALUES
     (1, 2, 1, 'Hormiga1', 'Primera hormiga')
    ,(2, 1, 1, 'Hormiga2', 'Segunda hormiga')
    ,(3, 2, 1, 'Hormiga3', 'Tercera hormiga')
    ,(4, 1, 1, 'Hormiga4', 'Cuarta hormiga' );

SELECT * FROM ZSSexo;
SELECT * FROM ZSHormigaTipo;
SELECT * FROM ZSEstado;
SELECT * FROM ZSAlimentoTipo;
SELECT * FROM ZSHormiga;

DROP VIEW IF EXISTS vwZSHormiga;

CREATE VIEW vwZSHormiga AS
SELECT
    H.IdZSHormiga
   ,HT.zsNombre AS ZSTipo
   ,S.zsNombre  AS ZSSexo
   ,E.zsNombre  AS ZSEstadoHormiga
   ,H.zsNombre  AS ZSNombre
   ,H.zsDescripcion
   ,H.zsEstado
   ,H.zsFechaCreacion
   ,H.zsFechaModifica
FROM ZSHormiga H
JOIN ZSHormigaTipo    HT ON H.IdZSHormigaTipo = HT.IdZSHormigaTipo
JOIN ZSSexo           S  ON H.IdZSSexo        = S.IdZSSexo
JOIN ZSEstado         E  ON H.IdZSEstado      = E.IdZSEstado
WHERE H.zsEstado = 'A'; 

SELECT * FROM vwZSHormiga;  

SELECT IdZSHormiga
 ,ZSTipo
 ,ZSSexo
 ,ZSEstadoHormiga
 ,ZSNombre
 ,ZSDescripcion
 ,ZSEstado
 ,ZSFechaCreacion
 ,ZSFechaModifica FROM vwZSHormiga;
SELECT * FROM ZSHormiga;

SELECT * FROM ZSEstado;

UPDATE ZSEstado SET zsNombre = 'VIVA' 
WHERE IdZSEstado = 1;

UPDATE ZSEstado SET zsNombre = 'MUERTA'
WHERE IdZSEstado = 2;

UPDATE ZSEstado SET zsNombre = 'X'
WHERE IdZSEstado = 3;

SELECT *
FROM ZSHormiga
WHERE IdZSHormiga BETWEEN 5 AND 19;


DELETE FROM ZSHormiga
WHERE IdZSHormiga BETWEEN 5 AND 19;

CREATE TABLE ZSEntomologo (
     IdZSEntomologo   INTEGER PRIMARY KEY AUTOINCREMENT     
    ,zsUsuario        VARCHAR(15) NOT NULL UNIQUE
    ,zsClave          VARCHAR(100) NULL
    ,zsEstado         VARCHAR(1)  NOT NULL DEFAULT ('A')
    ,zsFechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,zsFechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

INSERT INTO ZSEntomologo (zsUsuario, zsClave) VALUES
     ('patmic', '123')
    ,('ZunigaSebastian', '1706');
