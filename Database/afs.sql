-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 05, 2021 at 06:08 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `afs`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminaccounts`
--

DROP TABLE IF EXISTS `adminaccounts`;
CREATE TABLE IF NOT EXISTS `adminaccounts` (
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminaccounts`
--

INSERT INTO `adminaccounts` (`username`, `password`) VALUES
('aurora@gmail.com', '123456789');

-- --------------------------------------------------------

--
-- Table structure for table `analysed`
--

DROP TABLE IF EXISTS `analysed`;
CREATE TABLE IF NOT EXISTS `analysed` (
  `questionNo` int(11) NOT NULL,
  `answer1` int(11) NOT NULL,
  `answer2` int(11) NOT NULL,
  `answer3` int(11) DEFAULT NULL,
  `answer4` int(11) DEFAULT NULL,
  PRIMARY KEY (`questionNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `analysed`
--

INSERT INTO `analysed` (`questionNo`, `answer1`, `answer2`, `answer3`, `answer4`) VALUES
(1, 6, 1, 1, 0),
(2, 5, 1, 1, 1),
(3, 6, 2, NULL, NULL),
(4, 4, 2, NULL, NULL),
(5, 6, 2, NULL, NULL),
(6, 3, 3, 1, 1),
(7, 3, 3, 0, 2),
(8, 4, 1, 2, 1),
(9, 3, 3, 1, 1),
(10, 3, 2, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
CREATE TABLE IF NOT EXISTS `driver` (
  `email` varchar(75) NOT NULL,
  `name` varchar(75) NOT NULL,
  `age` int(11) NOT NULL,
  `conNum` int(11) NOT NULL,
  `Address` varchar(500) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`email`, `name`, `age`, `conNum`, `Address`) VALUES
('arjunperera@gmail.com', 'Arjun Perera', 23, 123456789, 'Negembo, Sri Lanka'),
('brianfernando@gmail.com', 'Brian Fernando', 23, 123456789, 'Ja Ela, Sri Lanka'),
('induranawarathne@gmail.com', 'Indura Nawarathne', 22, 710298758, '96/50, Old Kesbewa Road, Nugegoda'),
('malinduransara@gmail.com', 'Malindu Nawarathne', 22, 710892857, '96/48, Old Kesbewa Road, Nugegoda'),
('nawarathne@gmail.com', 'Malindu Nawarathne', 23, 123456789, 'Nugegoda, Sri Lanka'),
('thaveesharuchiran@gmail.com', 'Thaveesha Ruchiran', 23, 123456789, 'Weyangoda, Sri Lanka');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE IF NOT EXISTS `questions` (
  `qno` int(11) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer1` varchar(30) DEFAULT NULL,
  `answer2` varchar(30) DEFAULT NULL,
  `answer3` varchar(30) DEFAULT NULL,
  `answer4` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`qno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`qno`, `question`, `answer1`, `answer2`, `answer3`, `answer4`) VALUES
(1, 'What is your age? ', NULL, NULL, NULL, NULL),
(2, 'Did the driver arrive at time?', 'Punctual', 'Slightly late', 'Late', 'Extremely late'),
(3, 'Was the driver friendly? ', 'Yes ', 'No', NULL, NULL),
(4, 'Did the driver drive safely? ', 'Yes', 'No', NULL, NULL),
(5, 'Did the driver choose the most convenient route?', 'Yes', 'No', NULL, NULL),
(6, 'Are you satisfied with your overall experience?', 'Strongly agree', 'Agree', 'Disagree', 'Strongly disagree'),
(7, 'How do you describe the comfortability of the vehicle?  ', 'Excellent', 'Good ', 'Neutral', 'Bad'),
(8, 'Are you satisfied with the quality of your last rented vehicle (cleanliness, appearance)? ', 'Strongly agree', 'Agree', 'Disagree', 'Strongly disagree'),
(9, 'How do you describe your last trip', 'Excellent', 'Good ', 'Neutral', 'Bad'),
(10, 'What is your favorite car in our fleet? (Based on your experience with past rentals) ', 'Toyota Corolla Axio', 'Toyota Premio', 'Audi S4', 'BMW 520d');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `invNo` varchar(10) NOT NULL,
  `driverID` varchar(75) DEFAULT NULL,
  `vehicleID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`invNo`),
  KEY `reservationDrvIdFKey` (`driverID`),
  KEY `reservationVehIdFKey` (`vehicleID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`invNo`, `driverID`, `vehicleID`) VALUES
('afs2021', 'malinduransara@gmail.com', 'CAY9996'),
('afs2022', 'induranawarathne@gmail.com', 'CAY9997'),
('afs2023', 'arjunperera@gmail.com', 'CAY9996'),
('afs2024', 'thaveesharuchiran@gmail.com', 'CAY9997'),
('afs2025', 'brianfernando@gmail.com', 'CAY9996'),
('afs2026', 'brianfernando@gmail.com', 'CAY9997'),
('afs2027', 'malinduransara@gmail.com', 'CAY9996'),
('afs2028', 'induranawarathne@gmail.com', 'CAY9997'),
('afs2029', 'brianfernando@gmail.com', 'CAY9998'),
('afs2030', 'thaveesharuchiran@gmail.com', 'CAY9999');

-- --------------------------------------------------------

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
CREATE TABLE IF NOT EXISTS `response` (
  `invNo` varchar(10) NOT NULL,
  `question1` varchar(25) NOT NULL,
  `question2` varchar(25) NOT NULL,
  `question3` varchar(25) NOT NULL,
  `question4` varchar(25) NOT NULL,
  `question5` varchar(25) NOT NULL,
  `question6` varchar(25) NOT NULL,
  `question7` varchar(25) NOT NULL,
  `question8` varchar(25) NOT NULL,
  `question9` varchar(25) NOT NULL,
  `question10` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`invNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `response`
--

INSERT INTO `response` (`invNo`, `question1`, `question2`, `question3`, `question4`, `question5`, `question6`, `question7`, `question8`, `question9`, `question10`) VALUES
('afs2021', '21', 'Punctual', 'Yes', 'Yes', 'Yes', 'Strongly agree', 'Excellent', 'Strongly agree', 'Excellent', 'Toyota Corolla Axio'),
('afs2022', '24', 'Punctual', 'Yes', 'Yes', 'Yes', 'Agree', 'Good', 'Strongly agree', 'Excellent', 'Toyota Premio'),
('afs2023', '43', 'Slightly Late', 'Yes', 'No', 'Yes', 'Agree', 'Good', 'Agree', 'Good', 'Audi S4'),
('afs2024', '31', 'Punctual', 'Yes', 'No', 'Yes', 'Strongly agree', 'Excellent', 'Disagree', 'Good', 'Toyota Corolla Axio'),
('afs2025', '21', 'Punctual', 'Yes', 'Yes', 'Yes', 'Agree', 'Good', 'Strongly agree', 'Good', 'BMW 520d'),
('afs2026', '26', 'Extremely Late', 'No', 'No', 'No', 'Strongly disagree', 'Bad', 'Strongly disagree', 'Bad', 'Audi S4'),
('afs2027', '24', 'Late', 'No', 'No', 'No', 'Disagree', 'Bad', 'Disagree', 'Neutral', 'Toyota Corolla Axio'),
('afs2028', '21', 'Punctual', 'Yes', 'Yes', 'Yes', 'Strongly agree', 'Excellent', 'Strongly agree', 'Excellent', 'Toyota Premio');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `vehNumber` varchar(10) NOT NULL,
  `vehBrand` varchar(75) NOT NULL,
  `vehYom` int(11) NOT NULL,
  `ownerName` varchar(75) NOT NULL,
  `ownerEmail` varchar(75) NOT NULL,
  `ownerConNum` int(11) NOT NULL,
  `ownerAddress` varchar(500) NOT NULL,
  PRIMARY KEY (`vehNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehNumber`, `vehBrand`, `vehYom`, `ownerName`, `ownerEmail`, `ownerConNum`, `ownerAddress`) VALUES
('CAY9996', 'Toyota Corolla Axio', 2017, 'Malindu Nawarathne', 'malindurnawarathne@gmail.com', 710857892, '96/40, Old Kesbewa Road, Nugegoda'),
('CAY9997', 'Jaguar XF', 2017, 'Peter Jacobson', 'petetjacobson@gmail.com', 710851891, 'Adilade, New Zeland'),
('CAY9998', 'Benz E330', 2014, 'Subodha Perera', 'subodhaperera@gmail.com', 123456789, 'Nugegoda, Sri Lanka'),
('CAY9999', 'BMW 520D', 2015, 'Amantha Wisidagama', 'amanthawisidagama@gmail.com', 123456789, 'MahaBagee, Sri Lanka');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservationDrvIdFKey` FOREIGN KEY (`driverID`) REFERENCES `driver` (`email`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `reservationVehIdFKey` FOREIGN KEY (`vehicleID`) REFERENCES `vehicle` (`vehNumber`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
