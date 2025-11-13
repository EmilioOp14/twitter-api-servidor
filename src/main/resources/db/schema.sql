-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema social_network
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema social_network
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `social_network` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `social_network` ;

-- -----------------------------------------------------
-- Table `social_network`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `social_network`.`roles` (
  `rol_id` INT NOT NULL AUTO_INCREMENT,
  `rol_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rol_id`),
  UNIQUE INDEX `rol_name_UNIQUE` (`rol_name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `social_network`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `social_network`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  `description` TEXT,
  `create_date` DATE NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7` (`email` ASC) VISIBLE,
  UNIQUE INDEX `UK_r43af9ap4edm43mmtq01oddj6` (`username` ASC) VISIBLE,
  INDEX `role_id_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `role_id`
    FOREIGN KEY (`role_id`)
    REFERENCES `social_network`.`roles` (`rol_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 23
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `social_network`.`follows`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `social_network`.`follows` (
  `following_id` INT NOT NULL,
  `follower_id` INT NOT NULL,
  `follow_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`follow_id`),
  INDEX `FKqnkw0cwwh6572nyhvdjqlr163` (`follower_id` ASC) VISIBLE,
  INDEX `FK45sy1jkos9oy1j4by9y7225nm` (`following_id` ASC) VISIBLE,
  CONSTRAINT `FK45sy1jkos9oy1j4by9y7225nm`
    FOREIGN KEY (`following_id`)
    REFERENCES `social_network`.`users` (`user_id`),
  CONSTRAINT `FKqnkw0cwwh6572nyhvdjqlr163`
    FOREIGN KEY (`follower_id`)
    REFERENCES `social_network`.`users` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `social_network`.`publications`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `social_network`.`publications` (
  `publication_id` INT NOT NULL AUTO_INCREMENT,
  `creation_date` DATETIME(6) NOT NULL,
  `edit_date` DATETIME(6) NULL DEFAULT NULL,
  `user_id` INT NOT NULL,
  `text` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`publication_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `social_network`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 38
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
