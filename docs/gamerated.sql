-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 28-03-2023 a las 16:33:53
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gamerated`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentariojuego`
--

CREATE TABLE `comentariojuego` (
  `id` bigint(20) NOT NULL,
  `texto` varchar(255) NOT NULL,
  `fechahora` datetime NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  `id_juego` bigint(20) NOT NULL,
  `id_comentariojuego` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juego`
--

CREATE TABLE `juego` (
  `id` bigint(20) NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `desarrolladora` varchar(255) NOT NULL,
  `plataforma` varchar(255) NOT NULL,
  `fechasalida` datetime NOT NULL,
  `genero` varchar(255) NOT NULL,
  `duracion` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `nick` varchar(255) NOT NULL,
  `pass` varchar(1024) NOT NULL,
  `tipocuenta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoracionjuego`
--

CREATE TABLE `valoracionjuego` (
  `id` bigint(20) NOT NULL,
  `id_usuario` bigint(20) NOT NULL,
  `id_juego` bigint(20) NOT NULL,
  `nota` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comentariojuego`
--
ALTER TABLE `comentariojuego`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `juego`
--
ALTER TABLE `juego`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valoracionjuego`
--
ALTER TABLE `valoracionjuego`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comentariojuego`
--
ALTER TABLE `comentariojuego`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `juego`
--
ALTER TABLE `juego`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `valoracionjuego`
--
ALTER TABLE `valoracionjuego`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
