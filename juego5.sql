-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`orden` (
  `idorden` INT NOT NULL AUTO_INCREMENT,
  `columnas` INT NOT NULL,
  `filas` INT NOT NULL,
  PRIMARY KEY (`idorden`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`juego`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`juego` (
  `idjuego` INT NOT NULL AUTO_INCREMENT,
  `orden_idorden` INT NOT NULL,
  PRIMARY KEY (`idjuego`),
  INDEX `fk_juego_orden1_idx` (`orden_idorden` ASC) VISIBLE,
  CONSTRAINT `fk_juego_orden1`
    FOREIGN KEY (`orden_idorden`)
    REFERENCES `mydb`.`orden` (`idorden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`imagenes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `imagen` BLOB NOT NULL,
  `contenttype` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `juego_idjuego` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_imagenes_juego_idx` (`juego_idjuego` ASC) VISIBLE,
  CONSTRAINT `fk_imagenes_juego`
    FOREIGN KEY (`juego_idjuego`)
    REFERENCES `mydb`.`juego` (`idjuego`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
