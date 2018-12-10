-- MySQL Script generated by MySQL Workbench
-- lun 19 nov 2018 19:53:43 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema uaebiblioteca
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `uaebiblioteca` ;

-- -----------------------------------------------------
-- Schema uaebiblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uaebiblioteca` DEFAULT CHARACTER SET utf8 ;
USE `uaebiblioteca` ;

-- -----------------------------------------------------
-- Table `uaebiblioteca`.`AUTOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uaebiblioteca`.`autor` ;

CREATE TABLE IF NOT EXISTS `uaebiblioteca`.`autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` VARCHAR(500) NULL,
  `nacionalidad` VARCHAR(100) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uaebiblioteca`.`CATEGORIA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uaebiblioteca`.`categoria` ;

CREATE TABLE IF NOT EXISTS `uaebiblioteca`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uaebiblioteca`.`EDITORIAL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uaebiblioteca`.`editorial` ;

CREATE TABLE IF NOT EXISTS `uaebiblioteca`.`editorial` (
  `idEditorial` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(400) NULL,
  `direccion` VARCHAR(500) NULL,
  `telefono` VARCHAR(45) NULL,
  `contacto` VARCHAR(300) NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uaebiblioteca`.`LIBRO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uaebiblioteca`.`libro` ;

CREATE TABLE IF NOT EXISTS `uaebiblioteca`.`libro` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(300) NULL,
  `edicion` INT NULL,
  `fecha_publicacion` INT NULL,
  `isbn` VARCHAR(100) NULL,
  `numero_paginas` INT NULL,
  `codigo` VARCHAR(45) NULL,
  `condicion_fisica` VARCHAR(400) NULL,
  `estado` INT NULL,
  `comentario` MEDIUMTEXT NULL,
  `idAutor` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  `idEditorial` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `idAutor`, `idEditorial`),
  CONSTRAINT `fk_LIBRO_AUTOR`
    FOREIGN KEY (`idAutor`)
    REFERENCES `uaebiblioteca`.`AUTOR` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIBRO_CATEGORIA1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `uaebiblioteca`.`CATEGORIA` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LIBRO_EDITORIAL1`
    FOREIGN KEY (`idEditorial`)
    REFERENCES `uaebiblioteca`.`EDITORIAL` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- CREATE INDEX `fk_LIBRO_AUTOR_idx` ON `uaebiblioteca`.`LIBRO` (`idAutor` ASC) VISIBLE;

-- CREATE INDEX `fk_LIBRO_CATEGORIA1_idx` ON `uaebiblioteca`.`LIBRO` (`idCategoria` ASC) VISIBLE;

 -- CREATE INDEX `fk_LIBRO_EDITORIAL1_idx` ON `uaebiblioteca`.`LIBRO` (`idEditorial` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `uaebiblioteca`.`PRESTAMO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uaebiblioteca`.`prestamo` ;

CREATE TABLE IF NOT EXISTS `uaebiblioteca`.`prestamo` (
  `idPrestamo` INT NOT NULL AUTO_INCREMENT,
  `fecha_entrega` DATETIME NULL,
  `fecha_devolucion` DATETIME NULL,
  `monto_mora` DECIMAL NULL,
  `carnet_estudiante` VARCHAR(50) NULL,
  `nombre_encargado` VARCHAR(500) NULL,
  `fecha_creacion` DATETIME NULL,
  `idLibro` INT NOT NULL,
  `idAutor` INT NOT NULL,
  `idEditorial` INT NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  CONSTRAINT `fk_PRESTAMO_LIBRO1`
    FOREIGN KEY (`idLibro` , `idAutor` , `idEditorial`)
    REFERENCES `uaebiblioteca`.`LIBRO` (`idLibro` , `idAutor` , `idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- CREATE INDEX `fk_PRESTAMO_LIBRO1_idx` ON `uaebiblioteca`.`PRESTAMO` (`idLibro` ASC, `idAutor` ASC, `idEditorial` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

use uaebiblioteca;
select * from autor ; 


