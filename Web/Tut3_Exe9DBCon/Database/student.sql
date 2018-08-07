-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 08, 2018 at 07:43 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `stud`
--

DROP TABLE IF EXISTS `stud`;
CREATE TABLE IF NOT EXISTS `stud` (
  `StudRollno` int(11) NOT NULL,
  `StudName` varchar(255) NOT NULL,
  `StudAge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stud`
--

INSERT INTO `stud` (`StudRollno`, `StudName`, `StudAge`) VALUES
(4, 'Rushik', 18);

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
CREATE TABLE IF NOT EXISTS `student_details` (
  `Stud_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Stud_Name` varchar(255) NOT NULL,
  `Birth_Date` date NOT NULL,
  `City` varchar(255) NOT NULL,
  `Course` varchar(255) NOT NULL,
  `Semester` varchar(255) NOT NULL,
  `Division` int(11) NOT NULL,
  PRIMARY KEY (`Stud_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COMMENT='student_details table';

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`Stud_Id`, `Stud_Name`, `Birth_Date`, `City`, `Course`, `Semester`, `Division`) VALUES
(1, 'Rushik', '2018-07-02', 'Rajkot', 'BCA', '1', 1),
(2, 'aakash', '2018-07-02', 'rajkot', 'BCA', '2', 3),
(3, 'meet', '2018-07-02', 'rajkot', 'BCA', '3', 3),
(4, 'rushi', '2018-07-02', 'Rajkot', 'BCA', '2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `student_marksheet`
--

DROP TABLE IF EXISTS `student_marksheet`;
CREATE TABLE IF NOT EXISTS `student_marksheet` (
  `Stud_Id` int(11) NOT NULL,
  `Mark1` int(11) NOT NULL,
  `Mark2` int(11) NOT NULL,
  `Mark3` int(11) NOT NULL,
  `Total` int(11) NOT NULL,
  `Percentage` float NOT NULL,
  `Grade` varchar(1) NOT NULL,
  PRIMARY KEY (`Stud_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_marksheet`
--

INSERT INTO `student_marksheet` (`Stud_Id`, `Mark1`, `Mark2`, `Mark3`, `Total`, `Percentage`, `Grade`) VALUES
(1, 50, 50, 50, 150, 50, 'A'),
(2, 70, 70, 70, 210, 70, 'A'),
(3, 60, 60, 60, 180, 60, 'B'),
(4, 80, 80, 80, 240, 80, 'A');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_marksheet`
--
ALTER TABLE `student_marksheet`
  ADD CONSTRAINT `student_marksheet_ibfk_1` FOREIGN KEY (`Stud_Id`) REFERENCES `student_details` (`Stud_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
