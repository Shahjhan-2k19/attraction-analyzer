-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tour
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tour
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tour` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tour` ;

-- -----------------------------------------------------
-- Table `tour`.`attractions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tour`.`attractions` (
  `Name` VARCHAR(300) NULL DEFAULT NULL,
  `Url` VARCHAR(300) NULL DEFAULT NULL,
  `Telephone` VARCHAR(300) NULL DEFAULT NULL,
  `Longitude` VARCHAR(300) NULL DEFAULT NULL,
  `Latitude` VARCHAR(300) NULL DEFAULT NULL,
  `AddressRegion` VARCHAR(300) NULL DEFAULT NULL,
  `AddressLocality` VARCHAR(300) NULL DEFAULT NULL,
  `AddressCountry` VARCHAR(300) NULL DEFAULT NULL,
  `Tags` VARCHAR(300) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
