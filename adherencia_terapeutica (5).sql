-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2019 a las 15:21:44
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `adherencia_terapeutica`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `ConsultaGeneralAdulto` ()  select * from Adulto_mayor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Consulta_Adulto` (IN `Id_Adulto` VARCHAR(12))  select * from Adulto_mayor where Id_Adult=Id_Adulto$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_CUIDADOR_ESPE` (IN `ID_CUIDA` VARCHAR(12))  SELECT * FROM CUIDADOR WHERE Id_Cuid = ID_CUIDA$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_ESPE_ALARMA` (IN `ID_ALA` SMALLINT)  SELECT * FROM ALARMA WHERE ID_ALARM = ID_ALA$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_ESPE_ENFERMEDAD` (IN `ID_ENFER` SMALLINT)  SELECT * FROM ENFERMEDAD WHERE ID_ENF = ID_ENFER$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_ESPE_RC` (IN `ID_RECM` SMALLINT)  SELECT * FROM RECETA_MEDICA WHERE ID_REC=ID_RECM$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_ESPE_REPORTE` (IN `ID_REPO` SMALLINT)  SELECT * FROM REPORTE WHERE ID_REPORTE=ID_REPO$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_ESPE_USUARIO` (IN `ID_USU` SMALLINT)  SELECT * FROM USUARIO WHERE usuario_id=ID_USU$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_FAMILIAR_ESPE` (IN `ID_FAMI` VARCHAR(12))  SELECT * FROM FAMILIAR WHERE ID_FAM = ID_FAMI$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_ALARMA` ()  SELECT * FROM ALARMA$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_CUIDADOR` ()  SELECT * FROM CUIDADOR$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_ENFERMEDAD` ()  SELECT * FROM ENFERMEDAD$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_FAMILIAR` ()  SELECT * FROM FAMILIAR$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_MEDICAMENTO` ()  SELECT * FROM MEDICAMENTO$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_RC` ()  SELECT * FROM RECETA_MEDICA$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_REPORTE` ()  SELECT * FROM REPORTE$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_GENE_USUARIO` ()  SELECT * FROM usuario$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CONSULTA_MED_ESPE` (IN `ID_MEDI` VARCHAR(30))  SELECT * FROM MEDICAMENTO WHERE ID_MED = ID_MEDI$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_alarma` (IN `Idala` SMALLINT)  delete from alarma where id=idala$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_usuario` (IN `Idusu` SMALLINT)  delete from usuario where usuario_id=idusu$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_adulto` (IN `Id` VARCHAR(12), IN `nombre` VARCHAR(30), IN `apellido` VARCHAR(30), IN `genero` VARCHAR(1), IN `fecha_nacimiento` DATE, IN `foto` BLOB)  insert into adulto_mayor values(Id, nombre, apellido, genero, fecha_nacimiento, foto)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_alarma` (IN `id` SMALLINT, IN `Viam` VARCHAR(15), IN `cantidad` VARCHAR(4), IN `dosis` VARCHAR(5), IN `frecuencia` VARCHAR(5), IN `fechain` VARCHAR(45), IN `fechafin` VARCHAR(45), IN `idcuid` VARCHAR(12), IN `idmed` SMALLINT)  insert into alarma values(id, viam,cantidad, dosis, frecuencia, fechain, fechafin, idcuid, idmed)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cuidador` (IN `Id` VARCHAR(12), IN `nombre` VARCHAR(30), IN `apellido` VARCHAR(30), IN `numero` VARCHAR(20), IN `email` VARCHAR(25), IN `foto` BLOB, IN `id_usu` SMALLINT)  insert into cuidador values(Id, nombre, apellido, numero, email, foto,id_usu)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_enfermedad` (IN `Id` SMALLINT, `nombre` VARCHAR(30), `sintomas` VARCHAR(200), `tratamiento` VARCHAR(200))  insert into enfermedad values(Id, nombre, sintomas, tratamiento)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_familiar` (IN `Id` VARCHAR(24), IN `nombre` VARCHAR(30), IN `apellido` VARCHAR(30), IN `parentesco` VARCHAR(15), IN `email` VARCHAR(30), IN `foto` BLOB, IN `idadulto` MEDIUMINT, IN `id_usu` SMALLINT)  insert into familiar values(Id, nombre, apellido, parentesco, email, foto, idadulto, id_usu)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_medicamento` (IN `Id` SMALLINT, `nombre` VARCHAR(30), `fechaven` DATE, `composicion` BLOB, `viamed` VARCHAR(15), `cantidad` VARCHAR(4), `dosis` VARCHAR(5), `nombrelab` VARCHAR(25), `contraindicaciones` BLOB)  insert into medicamento values(Id, nombre, fechaven, composicion, viamed, cantidad, dosis, nombrelab, contraindicaciones)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_receta` (IN `id` SMALLINT, IN `fecha` DATE, IN `nombreMed` VARCHAR(30), IN `cantidad` VARCHAR(4), IN `dosis` VARCHAR(5), IN `Via_Admin` VARCHAR(15), IN `idenf` SMALLINT, IN `Idadulto` VARCHAR(12))  insert into receta_medica values(id, fecha,nombreMed,cantidad,dosis,Via_Admin, idenf,idadulto)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_reporte` (IN `Id` SMALLINT, `fecha` DATE, `comportamiento` VARCHAR(250), `Idadult` VARCHAR(12))  insert into reporte values(Id, fecha, comportamiento, idadult)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuario` (IN `Id` SMALLINT, IN `nombre` VARCHAR(50), IN `contraseña` VARCHAR(50), IN `rol` SMALLINT(6), IN `nombrecompleto` VARCHAR(50))  insert into usuario values(Id, nombre, contraseña,rol, nombrecompleto)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_adulto` (IN `Id` INT, IN `nombre` VARCHAR(45), IN `apellido` VARCHAR(45), IN `genero` VARCHAR(1), IN `fecha` VARCHAR(45), IN `foto` BLOB)  begin
 
UPDATE adulto_mayor 
SET Nombres_Adult = nombre,
Apellidos_Adult = apellido,
Genero_Adult = genero,
Fecha_Nac_Adult = fecha,
Foto_Adult = foto
WHERE Id_Adult= Id;
 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_alarma` (IN `Id` INT, IN `Via` VARCHAR(45), IN `Cantidad` VARCHAR(45), IN `Dosis` VARCHAR(45), IN `Frecuencia_Medica` VARCHAR(45), IN `Fechai` DATE, IN `Fechaf` DATE)  begin
 
UPDATE alarma 
SET Via_Adminis_Alarm = Via,
Cantidad_Alarm = Cantidad,
Dosis_Medica_Alarm = Dosis,
Frecuencia_Medica_Alarm = Frecuencia_Medica,
Fecha_Inicio_Alarm = Fechai,
Fecha_Final_Alarm = Fechaf
WHERE Id_Alarm= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_cuidador` (IN `Id` INT, IN `Nombre` VARCHAR(45), IN `Apellidos` VARCHAR(45), IN `Telefono` VARCHAR(45), IN `Email` VARCHAR(45), IN `Foto` VARCHAR(45), IN `usuario` VARCHAR(45))  begin
 
UPDATE cuidador 
SET Nombre_Cuid = Nombre,
Apellidos_Cuid = Apellidos,
Telefono_Cuid = Telefono,
Email_Cuid = Email,
Foto_Cuid = Foto,
Id_Usuario = usuario
WHERE Id_Cuid= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_enfermedad` (IN `Id` INT, IN `Nombre` VARCHAR(45), IN `Sintomas` VARCHAR(200), IN `Tratamiento` VARCHAR(200))  begin
 
UPDATE enfermedad 
SET Nombre_Enf = Nombre,
Sintomas_Enf = Sintomas,
Tratamiento_Enf = Tratamiento
WHERE Id_Enf= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_familiar` (IN `Id` VARCHAR(12), IN `Nombre` VARCHAR(45), IN `Apellidos` VARCHAR(45), IN `Parentesco` VARCHAR(45), IN `email` VARCHAR(45), IN `foto` VARCHAR(45))  begin
 
UPDATE familiar 
SET Nombre_Fam = Nombre,
Apellidos_Fam = Apellidos,
Parentesco_Fam = Parentesco,
Email_Fam = email,
Foto_Fam = foto

WHERE Id_Fam= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_medicamento` (IN `Id` INT, IN `Nombre` VARCHAR(45), IN `Fecha_Venci` VARCHAR(45), IN `composi` BLOB, IN `Via` VARCHAR(45), IN `Cantidad` VARCHAR(45), IN `Dosis` VARCHAR(45), IN `Nomlab` VARCHAR(45), IN `Contraindi` BLOB)  begin
 
UPDATE medicamento 
SET Nombre_Med = Nombre,
Fecha_Venci_Med = Fecha_Venci,
Composi_Med = composi,
Via_Med = Via,
Cantidad_Med = Cantidad,
Dosis_Med = Dosis,
Nom_Lab_Med = Nomlab,
Contraindi_Med = Contraindi
WHERE Id_Med= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_receta` (IN `Id` INT, IN `Fecha` VARCHAR(45), IN `NomMed` VARCHAR(45), IN `cantidad` VARCHAR(45), IN `Dosis` VARCHAR(45), IN `Via` VARCHAR(45), IN `Idenf` VARCHAR(45), IN `Idadu` VARCHAR(45))  begin
 
UPDATE receta_medica
SET Fecha_Rec = Fecha,
Nom_Med_RecMed = NomMed,
cantidad_h_RecMed = cantidad,
Via_Adimn_RecMed = Via,
Id_Enfermedad = Idenf,
Id_Adult = Idadu
WHERE Id_Rec= Id;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modificar_usuario` (IN `id` SMALLINT(6), IN `nombre` VARCHAR(30), IN `nombres` VARCHAR(30), IN `contraseña` VARCHAR(30), IN `rol` SMALLINT(6))  NO SQL
UPDATE  usuario set usuario=nombre,contra=contraseña , nivelUsuario=rol ,nombre_completo=nombres where usuario_id=id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PALogin` (IN `nombre` VARCHAR(30), IN `contraseña` VARCHAR(30))  NO SQL
SELECT* FROM usuario WHERE usuario=nombre and contra=contraseña$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `PLogin` (IN `usuario` VARCHAR(30))  NO SQL
SELECT* FROM usuario WHERE usuario=usuario$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `adulto_mayor`
--

CREATE TABLE `adulto_mayor` (
  `Id_Adult` varchar(12) NOT NULL,
  `Nombres_Adult` varchar(30) NOT NULL,
  `Apellidos_Adult` varchar(30) NOT NULL,
  `Genero_Adult` enum('f','m') NOT NULL,
  `Fecha_Nac_Adult` date NOT NULL,
  `Foto_Adult` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `adulto_mayor`
--

INSERT INTO `adulto_mayor` (`Id_Adult`, `Nombres_Adult`, `Apellidos_Adult`, `Genero_Adult`, `Fecha_Nac_Adult`, `Foto_Adult`) VALUES
('1000615200', 'Felipe', 'Mendez', 'm', '1940-03-17', 0x31323033363539315f31303230383030323037343739343931365f323033363636383430383239323633383236355f6e2e6a7067),
('1002538237', 'Manuel', 'Fernandez', 'm', '1964-03-05', 0x62616e646963616d20323031372d30322d31312032302d34332d35332d3230332e6a7067),
('1007765657', 'Pedro', 'Picapiedra', 'm', '1957-01-12', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067),
('10324342', 'SASD', 'utffutf', 'f', '2020-02-12', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067),
('1234', 'kevin', 'manu', 'm', '2019-10-24', 0x494d4730303031412e6a7067),
('123456', 'Carolita', 'Forero', 'f', '1910-04-21', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067),
('1413241', '0', 'Mayorga', 'm', '1999-12-12', 0x31736661736661),
('213213', 'Maria', 'PeÃ±a', 'f', '1957-03-12', 0x756769682e6a7067),
('2321212', 'Pepe', 'Ruiz', 'm', '1957-11-12', ''),
('23856832', 'Rosa ', 'Vega', 'm', '2019-11-04', 0x62616e646963616d20323031372d30332d30352031362d35322d34302d3233392e6a7067),
('3432423', 'Mario', 'Ramses', 'm', '1111-03-12', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067),
('3636363', 'Fran', 'Sanchez', 'm', '1999-12-12', 0x494d4730303033412e6a7067),
('46464454', 'Cristian', 'Florez', 'm', '2019-11-04', 0x31323734323737375f31303230393030323738323733313938395f373537303631303233353237323238353234395f6e2e6a7067),
('562342', 'dfd', 'dffddf', 'f', '2019-11-14', 0x62616e646963616d20323031372d30332d30352031362d35322d34302d3233392e6a7067),
('80908098', 'gyyuguy', 'hiuhui', 'm', '2019-12-03', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067),
('8878787', 'Francis', 'Martin', 'm', '2019-11-27', 0x62616e646963616d20323031372d30332d30352031372d32332d32372d3135372e6a7067);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alarma`
--

CREATE TABLE `alarma` (
  `Id_Alarm` smallint(6) NOT NULL,
  `Via_Adminis_Alarm` varchar(25) NOT NULL,
  `Cantidad_Alarm` varchar(4) NOT NULL,
  `Dosis_Medica_Alarm` varchar(11) NOT NULL,
  `Frecuencia_Medica_Alarm` int(11) NOT NULL,
  `Fecha_Inicio_Alarm` date NOT NULL,
  `Fecha_Final_Alarm` date NOT NULL,
  `Id_Cuidador` varchar(12) NOT NULL,
  `Id_Medicamento` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alarma`
--

INSERT INTO `alarma` (`Id_Alarm`, `Via_Adminis_Alarm`, `Cantidad_Alarm`, `Dosis_Medica_Alarm`, `Frecuencia_Medica_Alarm`, `Fecha_Inicio_Alarm`, `Fecha_Final_Alarm`, `Id_Cuidador`, `Id_Medicamento`) VALUES
(900, 'Oral', '100', 'ml', 11, '2020-02-20', '2020-10-20', '1789798798', 1),
(1187, 'Oral', '187', 'g', 13, '2020-02-11', '2020-10-11', '35353', 1654),
(2092, 'Inyección', '12', 'mg', 11, '2020-12-12', '2021-12-12', '31231231', 4),
(2216, 'Oral', '100', 'mg', 15, '2019-02-12', '2020-12-12', '2132131', 1114),
(2595, 'Oral', '216', 'mg', 11, '1232-03-12', '2020-03-12', '1007450255', 1),
(3727, 'Inyección', '500', 'ml', 9, '2019-12-10', '2019-12-19', '342423424', 1154),
(4228, 'Oral', '100', 'g', 15, '2022-12-12', '2020-12-12', '20309393', 4),
(5326, 'Oral', '110', 'mg', 13, '2020-12-12', '2022-12-12', '2132131', 4),
(6528, 'Oral', '100', 'g', 10, '2019-12-12', '2020-12-12', '20309393', 32),
(6691, 'Inyección', '100', 'g', 16, '2020-12-12', '1202-12-12', '20309393', 1),
(7678, 'Oral', '100', 'g', 14, '2019-12-12', '2020-12-12', '1789798798', 4),
(8226, 'Oral', '100', 'mg', 13, '1232-02-12', '3333-12-12', '1789798798', 4),
(9791, 'Inyección', '100', 'mg', 14, '2020-12-12', '2021-12-12', '1789798798', 1),
(10343, 'Oral', '100', 'mg', 17, '2020-12-12', '2020-02-12', '20309393', 786),
(10829, 'Oral', '100', 'g', 13, '2019-12-12', '2020-12-12', '20309393', 1154),
(11050, 'Oral', '100', 'g', 14, '2019-12-12', '2020-12-12', '1789798798', 786);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuidador`
--

CREATE TABLE `cuidador` (
  `Id_Cuid` varchar(12) NOT NULL,
  `Nombre_Cuid` varchar(30) NOT NULL,
  `Apellidos_Cuid` varchar(30) NOT NULL,
  `Telefono_Cuid` varchar(10) NOT NULL,
  `Email_Cuid` varchar(25) NOT NULL,
  `Foto_Cuid` blob,
  `Id_Usuario` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cuidador`
--

INSERT INTO `cuidador` (`Id_Cuid`, `Nombre_Cuid`, `Apellidos_Cuid`, `Telefono_Cuid`, `Email_Cuid`, `Foto_Cuid`, `Id_Usuario`) VALUES
('1007450255', 'Maria', 'Suarez', 'maria@gmai', '213123123', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 2),
('1789798798', 'Maria', 'Suarez', 'maria@gmai', '32423423423', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 5112),
('20309393', 'Andrea', 'Mistral', 'andrea@gma', '23132312', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 2),
('2132131', 'Pepe', 'Ruiz', 'pepe@gmail', '213123213', 0x756769682e6a7067, 0),
('31231231', 'Raimundo', 'Ruiz', '2312312', 'raimundo@gmail.com', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067, 2),
('342423424', 'Martha', 'Suarez', 'ewqeqwe@gm', '3213312312', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 2),
('342545345', 'Jaime', 'Picapiedra', '23124234', 'jaime@gmail.com', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 2),
('35353', 'Juan', 'Mayorga', '234242', 'juan@gmail.com', 0x736466736673, 0),
('35435', 'ffghfghfg', 'yiuiyiu', 'tyuyt@gmai', '546576', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 2),
('432432', 'Jaime', 'Piracoca', '2312321', 'jaime@gmail.com', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 2),
('432432432', 'Maria', 'Suarez', 'maria@gmai', '432432432', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 5112),
('434324', 'Jaime', 'Piracoca', '32123123', 'jaime@gmail.com', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067, 2),
('43554354354', 'Nirza', 'Chacon', 'nirza@gmai', '31212312', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067, 2),
('54535435', 'Pedro', 'Picapiedra', 'pedro@gmai', '321343121', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 2),
('5765765', 'Rosa', 'Florez', '98979878', 'rosa@gmail.com', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 2),
('577657', 'Jaime', 'Piracoca', '2312312', 'jaime@gmail.com', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067, 2),
('665454', 'Nirza', 'Martinez', 'nirza@gmai', '32134123', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_adult_medi`
--

CREATE TABLE `detalle_adult_medi` (
  `Id_DAM` smallint(6) NOT NULL,
  `Id_Adulto` varchar(12) NOT NULL,
  `Id_Medicamento` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_med_enf`
--

CREATE TABLE `detalle_med_enf` (
  `Id_DME` smallint(6) NOT NULL,
  `Id_Enfermedad` smallint(6) NOT NULL,
  `Id_Medicamento` smallint(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `enfermedad`
--

CREATE TABLE `enfermedad` (
  `Id_Enf` smallint(6) NOT NULL,
  `Nombre_Enf` varchar(30) NOT NULL,
  `Sintomas_Enf` varchar(200) DEFAULT NULL,
  `Tratamiento_Enf` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `enfermedad`
--

INSERT INTO `enfermedad` (`Id_Enf`, `Nombre_Enf`, `Sintomas_Enf`, `Tratamiento_Enf`) VALUES
(0, 'tension alta', 'tension', 'Masajes en la espalda'),
(1, 'Alzhaimer', 'olvido', 'ejercicios\r\n'),
(2, 'osteoporosis', 'debilitacion', 'ejercicio'),
(900, 'ffyftyty', 'hghjgjhgjh', ' gfghfhgfhg'),
(1471, 'ojkopjoigh', 'hjgh', 'eaaeew'),
(1617, 'sdaasd', 'mmmmmmm', 'asSasaSAS'),
(3243, 'retreter', 'dsadsadsa', ' fghfghfghgfhfghf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familiar`
--

CREATE TABLE `familiar` (
  `Id_Fam` varchar(12) NOT NULL,
  `Nombre_Fam` varchar(30) NOT NULL,
  `Apellidos_Fam` varchar(30) NOT NULL,
  `Parentesco_Fam` varchar(15) NOT NULL,
  `Email_Fam` varchar(30) NOT NULL,
  `Foto_Fam` blob,
  `Id_Adulto` varchar(12) NOT NULL,
  `Id_Usuario` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `familiar`
--

INSERT INTO `familiar` (`Id_Fam`, `Nombre_Fam`, `Apellidos_Fam`, `Parentesco_Fam`, `Email_Fam`, `Foto_Fam`, `Id_Adulto`, `Id_Usuario`) VALUES
('123123123123', 'dfsddsf', 'dsfsdfsdf', 'Padrino', 'dsadsad@gmail.com', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, '1234', 0),
('43534', 'Maria', 'Ruiz', 'Sobrino', 'maria@gmail.com', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, '123456', 3),
('5677565758', 'Pepe', 'Ruiz', 'Sobrino', 'pepe@gmail.com', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, '213213', 0),
('9798696', 'Martha', 'Suarez', 'Tio', 'marta@gmail.com', 0x33363336333633, '3636363', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `Id_Med` smallint(6) NOT NULL,
  `Nombre_Med` varchar(30) NOT NULL,
  `Fecha_Venci_Med` date NOT NULL,
  `Composi_Med` blob,
  `Via_Med` varchar(15) NOT NULL,
  `Cantidad_Med` varchar(4) NOT NULL,
  `Dosis_Med` varchar(5) NOT NULL,
  `Nom_Lab_Med` varchar(25) NOT NULL,
  `Contraindi_Med` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`Id_Med`, `Nombre_Med`, `Fecha_Venci_Med`, `Composi_Med`, `Via_Med`, `Cantidad_Med`, `Dosis_Med`, `Nom_Lab_Med`, `Contraindi_Med`) VALUES
(1, 'Acetaminofen', '2019-12-12', 0x61636574616d656e, 'oral', '100', 'mg', 'bayer', 0x6164696363696f6e),
(4, 'Menina', '2019-12-12', 0x7366736673, 'oral', '100', 'ml', 'bayer', 0x64736773),
(32, 'Meina', '2019-10-24', 0x494d4730303032412e6a7067, 'Oral', '344', 'mg', 'Dex', 0x494d4730303034412e6a7067),
(786, 'sfdsfdsdf', '2020-12-12', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067, 'Oral', '100', 'mg', 'reer', 0xe23fa1205041554c412053414e54414d4152494120e23fa120284070617573616e74616d6172696131312920e23fa220466f746f73207920766964656f7320646520496e7374616772616d2e68746d6c),
(1114, 'Loratadina', '2019-11-07', 0x6e756c6c, 'null', 'null', 'null', 'null', 0x6e756c6c),
(1154, 'Mendina', '2020-12-13', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 'InyecciÃ?Â³n', '100', 'ml', 'fsdsffds', 0x313933333732375f31303230383731363833393836333539365f3635393432343035393136353636323930325f6e2e6a7067),
(1244, 'Lora', '3222-12-12', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 'Oral', '100', 'mg', 'ddsaddsa', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067),
(1566, 'Morfina', '2019-12-12', 0x31323734323737375f31303230393030323738323733313938395f373537303631303233353237323238353234395f6e2e6a7067, 'Oral', '100', 'ml', 'ggggg', 0x31323734323737375f31303230393030323738323733313938395f373537303631303233353237323238353234395f6e2e6a7067),
(1597, 'Losartan', '2020-12-13', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067, 'InyecciÃ³n', '100', 'ml', 'Genfar', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067),
(1654, 'MigraÃ±ol', '2019-11-23', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 'Oral', '100', 'ml', 'Genfar', 0x31333030303238375f31303230393535393632353831323731385f383833373435303335393536313430383934385f6e2e6a7067),
(2324, 'dfsdfdsf', '2020-12-12', 0x31333932303538325f31303231303435333930343634393133305f343333313832363132363936363030373431385f6e2e6a7067, 'Oral', '100', 'mg', 'dffdfds', 0x446179616e6120566173636f2e68746d6c);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta_medica`
--

CREATE TABLE `receta_medica` (
  `Id_Rec` smallint(6) NOT NULL,
  `Fecha_Rec` date NOT NULL,
  `NomMed_RecMed` varchar(30) NOT NULL,
  `cantidad_h_RecMed` varchar(12) NOT NULL,
  `DosisMed_RecMed` varchar(30) NOT NULL,
  `Via_Admin_RecMed` varchar(15) NOT NULL,
  `Id_Enfermedad` smallint(6) NOT NULL,
  `Id_Adult` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `receta_medica`
--

INSERT INTO `receta_medica` (`Id_Rec`, `Fecha_Rec`, `NomMed_RecMed`, `cantidad_h_RecMed`, `DosisMed_RecMed`, `Via_Admin_RecMed`, `Id_Enfermedad`, `Id_Adult`) VALUES
(1148, '2002-12-16', 'dasdasdsa', '100', 'g', 'Oral', 1, '1234'),
(1403, '2019-03-12', 'qwqeqw', '100', 'mg', 'Oral', 1, '1234'),
(1428, '2009-12-12', 'sadsadda', '100', 'g', 'Oral', 1, '1234'),
(2071, '3422-03-12', 'null', '188', 'g', 'InyecciÃ³n', 0, '46464454'),
(9298, '2019-12-10', 'null', '100', 'mg', 'Oral', 2, '1007765657'),
(32767, '1677-03-03', 'mmmmm', '100', 'm', 'oral', 1, '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `Id_Reporte` smallint(6) NOT NULL,
  `Fecha_Reporte` date NOT NULL,
  `Comportamiento` varchar(250) NOT NULL,
  `Id_Adult` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`Id_Reporte`, `Fecha_Reporte`, `Comportamiento`, `Id_Adult`) VALUES
(899, '2019-12-08', 'hgfhfhgfhgfghfhg', '1002538237'),
(1187, '2019-11-22', 'Lola esta bien', '1234'),
(1201, '2019-12-01', 'dsfsdfsdfs', '1234'),
(1326, '2019-11-21', 'fytfytfytfytytfty', '1234'),
(1527, '2019-11-22', 'se manchÃ³ toda la camisa', '1002538237'),
(1554, '2019-11-22', 'efedfsdfd', '1234'),
(1626, '2019-11-21', 'gigiugigiugiu', '3636363'),
(1733, '2019-11-22', 'se manchÃ³ toda la camisa', '123456'),
(1766, '2019-11-21', 'efedfsdfd', '213213'),
(1854, '2019-11-22', 'uhhjjh', '123456'),
(1864, '2019-11-22', 'asdadasdadsasdadsadsa', '123456'),
(2078, '2019-11-21', 'ytuytututyutuytuytuytuy', '1002538237'),
(2091, '2019-11-21', 'gyggfghfghfhgfhg', '213213'),
(4343, '2019-12-08', 'ftftyfty', '1002538237');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `Id_Rol` smallint(6) NOT NULL,
  `Tipo_Rol` enum('Administrador','Familiar','Cuidador') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`Id_Rol`, `Tipo_Rol`) VALUES
(1, 'Administrador'),
(2, 'Cuidador'),
(3, 'Familiar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario_id` smallint(6) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `contra` varchar(30) NOT NULL,
  `nivelUsuario` smallint(6) NOT NULL,
  `nombre_completo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario_id`, `usuario`, `contra`, `nivelUsuario`, `nombre_completo`) VALUES
(0, 'Pepe@gmail.com', '123456pe', 1, 'Pepe Ruiz'),
(2, 'Marta@gmail.com', '123456marta', 2, 'Martha Suarez'),
(3, 'Dayannadiaz@gmail.com', 'dayannadiaz12345', 3, 'Dayanna Diaz'),
(15, '213123123', '1007450255', 2, 'Maria'),
(16, 'manuel@gmail.com', '31231231', 1, 'Raimunda'),
(17, 'rosa@gmail.com', '5765765', 2, 'Rosa'),
(100, 'jaime12@gmail.com', '434324', 1, 'Jaime'),
(1396, 'maria@gmail.com', '43534', 3, 'Maria'),
(1569, 'Aprendiz777', 'oz7777', 2, 'Alejandro Munevar'),
(2509, 'Manuel3463', 'jkkjas', 1, 'Pablo Rodriguez'),
(4903, 'ddd@gmail.com', '77963b7a931377ad4ab5ad6a9cd718', 1, 'dd dd'),
(5111, 'Pablo777', 'elsanchez444', 2, 'Alejandro Munevar'),
(5112, 'pablo@gmail.com', 'pablo1234', 2, 'Pablo Escobar'),
(8704, 'cdflorez55@misena.edu.co', 'cdflorez', 1, 'Cristian F'),
(9340, '303322b0eccf174320f7f7fd6a7457', '12345pe', 1, 'Cristian Florez'),
(10153, 'mariaemp@gmail.com', '827ccb0eea8a706c4c34a16891f84e', 1, 'maria Emperatriz'),
(10464, 'cdflorez55@gmail.com', 'mario12', 1, 'Cristian Florez'),
(10867, 'pedro@gmail.com', '54535435', 2, 'Pedro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `adulto_mayor`
--
ALTER TABLE `adulto_mayor`
  ADD PRIMARY KEY (`Id_Adult`);

--
-- Indices de la tabla `alarma`
--
ALTER TABLE `alarma`
  ADD PRIMARY KEY (`Id_Alarm`),
  ADD KEY `Id_Cuidador` (`Id_Cuidador`),
  ADD KEY `Id_Medicamento` (`Id_Medicamento`);

--
-- Indices de la tabla `cuidador`
--
ALTER TABLE `cuidador`
  ADD PRIMARY KEY (`Id_Cuid`),
  ADD UNIQUE KEY `Id_Cuid` (`Id_Cuid`),
  ADD KEY `cuidador_ibfk_1` (`Id_Usuario`);

--
-- Indices de la tabla `detalle_adult_medi`
--
ALTER TABLE `detalle_adult_medi`
  ADD PRIMARY KEY (`Id_DAM`),
  ADD KEY `Id_Adulto` (`Id_Adulto`),
  ADD KEY `Id_Medicamento` (`Id_Medicamento`);

--
-- Indices de la tabla `detalle_med_enf`
--
ALTER TABLE `detalle_med_enf`
  ADD PRIMARY KEY (`Id_DME`),
  ADD KEY `Id_Enfermedad` (`Id_Enfermedad`),
  ADD KEY `Id_Medicamento` (`Id_Medicamento`);

--
-- Indices de la tabla `enfermedad`
--
ALTER TABLE `enfermedad`
  ADD PRIMARY KEY (`Id_Enf`);

--
-- Indices de la tabla `familiar`
--
ALTER TABLE `familiar`
  ADD PRIMARY KEY (`Id_Fam`),
  ADD UNIQUE KEY `Id_Adulto` (`Id_Adulto`),
  ADD KEY `Id_Usuario` (`Id_Usuario`);

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`Id_Med`);

--
-- Indices de la tabla `receta_medica`
--
ALTER TABLE `receta_medica`
  ADD PRIMARY KEY (`Id_Rec`),
  ADD KEY `Id_Adult` (`Id_Adult`),
  ADD KEY `Id_Enfermedad` (`Id_Enfermedad`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`Id_Reporte`),
  ADD KEY `Id_Adult` (`Id_Adult`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`Id_Rol`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario_id`),
  ADD UNIQUE KEY `Nom_Usuario` (`usuario`),
  ADD UNIQUE KEY `Contraseña` (`contra`),
  ADD KEY `Rol` (`nivelUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alarma`
--
ALTER TABLE `alarma`
  MODIFY `Id_Alarm` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11051;

--
-- AUTO_INCREMENT de la tabla `detalle_adult_medi`
--
ALTER TABLE `detalle_adult_medi`
  MODIFY `Id_DAM` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_med_enf`
--
ALTER TABLE `detalle_med_enf`
  MODIFY `Id_DME` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `enfermedad`
--
ALTER TABLE `enfermedad`
  MODIFY `Id_Enf` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3244;

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `Id_Med` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2325;

--
-- AUTO_INCREMENT de la tabla `receta_medica`
--
ALTER TABLE `receta_medica`
  MODIFY `Id_Rec` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32768;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `Id_Reporte` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4344;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `Id_Rol` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuario_id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10868;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alarma`
--
ALTER TABLE `alarma`
  ADD CONSTRAINT `alarma_ibfk_1` FOREIGN KEY (`Id_Cuidador`) REFERENCES `cuidador` (`Id_Cuid`),
  ADD CONSTRAINT `alarma_ibfk_2` FOREIGN KEY (`Id_Medicamento`) REFERENCES `medicamento` (`Id_Med`);

--
-- Filtros para la tabla `cuidador`
--
ALTER TABLE `cuidador`
  ADD CONSTRAINT `cuidador_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`usuario_id`);

--
-- Filtros para la tabla `detalle_adult_medi`
--
ALTER TABLE `detalle_adult_medi`
  ADD CONSTRAINT `detalle_adult_medi_ibfk_1` FOREIGN KEY (`Id_Adulto`) REFERENCES `adulto_mayor` (`Id_Adult`),
  ADD CONSTRAINT `detalle_adult_medi_ibfk_2` FOREIGN KEY (`Id_Medicamento`) REFERENCES `medicamento` (`Id_Med`);

--
-- Filtros para la tabla `detalle_med_enf`
--
ALTER TABLE `detalle_med_enf`
  ADD CONSTRAINT `detalle_med_enf_ibfk_1` FOREIGN KEY (`Id_Enfermedad`) REFERENCES `enfermedad` (`Id_Enf`),
  ADD CONSTRAINT `detalle_med_enf_ibfk_2` FOREIGN KEY (`Id_Medicamento`) REFERENCES `medicamento` (`Id_Med`);

--
-- Filtros para la tabla `familiar`
--
ALTER TABLE `familiar`
  ADD CONSTRAINT `familiar_ibfk_1` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`usuario_id`),
  ADD CONSTRAINT `familiar_ibfk_2` FOREIGN KEY (`Id_Adulto`) REFERENCES `adulto_mayor` (`Id_Adult`);

--
-- Filtros para la tabla `receta_medica`
--
ALTER TABLE `receta_medica`
  ADD CONSTRAINT `receta_medica_ibfk_1` FOREIGN KEY (`Id_Adult`) REFERENCES `adulto_mayor` (`Id_Adult`),
  ADD CONSTRAINT `receta_medica_ibfk_2` FOREIGN KEY (`Id_Enfermedad`) REFERENCES `enfermedad` (`Id_Enf`);

--
-- Filtros para la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD CONSTRAINT `reporte_ibfk_1` FOREIGN KEY (`Id_Adult`) REFERENCES `adulto_mayor` (`Id_Adult`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`nivelUsuario`) REFERENCES `rol` (`Id_Rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
