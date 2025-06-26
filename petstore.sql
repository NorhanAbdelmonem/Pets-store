-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2025 at 10:37 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `petstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'nor', 'nor');

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `customer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`customer_id`, `product_id`, `name`, `quantity`, `price`, `date`) VALUES
(1, 2, 'Toy', 4, 176, '2025-06-26'),
(1, 3, 'Dry-food', 5, 300, '2025-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(100) NOT NULL,
  `product_id` int(100) DEFAULT NULL,
  `name` varchar(30) NOT NULL,
  `status` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `image` varchar(225) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `product_id`, `name`, `status`, `price`, `image`, `date`) VALUES
(2, 1, 'neckband', 'Available', '20.0', 'C:\\Users\\Norhan\\Music\\petstore-master\\petstore-main\\pepepe.jpg', '2025-06-26'),
(4, 2, 'Toy', 'Available', '44.0', 'C:\\Users\\Norhan\\Videos\\petstore-master\\petstore-main\\pepe.jpg', '2025-06-26'),
(5, 3, 'Dry-food', 'Available', '60.0', 'C:\\Users\\Norhan\\Videos\\petstore-master\\petstore-main\\pppeeeeeeeeeettt.png', '2025-06-26'),
(6, 4, 'Sand', 'Not Available', '80.0', 'C:\\Users\\Norhan\\Videos\\petstore-master\\petstore-main\\ppeeepept.jpg', '2025-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `purchases`
--

CREATE TABLE `purchases` (
  `id` int(11) NOT NULL,
  `customer_id` varchar(11) NOT NULL,
  `total` varchar(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchases`
--

INSERT INTO `purchases` (`id`, `customer_id`, `total`, `date`) VALUES
(2, '2', '132.0', '2025-06-26'),
(3, '3', '66.0', '2025-06-26'),
(4, '4', '100.0', '2025-06-26'),
(5, '5', '80.0', '2025-06-26'),
(6, '6', '60.0', '2025-06-26'),
(7, '7', '1044.0', '2025-06-26'),
(8, '8', '492.0', '2025-06-26'),
(9, '9', '580.0', '2025-06-26'),
(10, '10', '172.0', '2025-06-26'),
(11, '10', '172.0', '2025-06-26'),
(12, '10', '592.0', '2025-06-26'),
(13, '1', '476.0', '2025-06-26');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchases`
--
ALTER TABLE `purchases`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `purchases`
--
ALTER TABLE `purchases`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
