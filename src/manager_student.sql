-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2018 at 04:43 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manager_student`
--

-- --------------------------------------------------------

--
-- Table structure for table `_lesson`
--

CREATE TABLE `_lesson` (
  `id` int(15) NOT NULL,
  `day` varchar(30) NOT NULL,
  `room` int(5) NOT NULL,
  `shift` int(2) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `teacher` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_lesson`
--

INSERT INTO `_lesson` (`id`, `day`, `room`, `shift`, `subject`, `teacher`) VALUES
(1, 'Monday', 202, 1, 'Toan roi rac', 'Le Duc Manh'),
(2, 'Tueday', 104, 2, 'Vat ly', 'Miss Thanh');

-- --------------------------------------------------------

--
-- Table structure for table `_message`
--

CREATE TABLE `_message` (
  `id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `deadline_date` date NOT NULL,
  `student_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_message`
--

INSERT INTO `_message` (`id`, `content`, `deadline_date`, `student_id`) VALUES
(2, '23', '2018-12-23', 1),
(3, '444', '2018-12-27', 1),
(5, 'qwe', '2018-12-29', 1);

-- --------------------------------------------------------

--
-- Table structure for table `_point`
--

CREATE TABLE `_point` (
  `semester` int(3) NOT NULL,
  `studentId` int(3) NOT NULL,
  `subjectId` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_point`
--

INSERT INTO `_point` (`semester`, `studentId`, `subjectId`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 1, 3),
(1, 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `_student`
--

CREATE TABLE `_student` (
  `_idSV` int(15) NOT NULL,
  `_user` varchar(50) NOT NULL,
  `_pass` varchar(20) NOT NULL,
  `_name` varchar(30) DEFAULT NULL,
  `_phone` varchar(11) DEFAULT NULL,
  `_email` varchar(50) DEFAULT NULL,
  `_status` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_student`
--

INSERT INTO `_student` (`_idSV`, `_user`, `_pass`, `_name`, `_phone`, `_email`, `_status`) VALUES
(1, 'Manh', '1', '123456', '', '', b'1'),
(2, 'luongthanh', '123456', 'Thanh', '0961651594', '1', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `_subject`
--

CREATE TABLE `_subject` (
  `_idSub` int(15) NOT NULL,
  `_nameSub` varchar(50) NOT NULL,
  `_hsCC` float NOT NULL,
  `_cc` varchar(4) NOT NULL,
  `_hsTH` float NOT NULL,
  `_th` varchar(4) NOT NULL,
  `_hsBT` float NOT NULL,
  `_bt` varchar(4) NOT NULL,
  `_hsKI` float NOT NULL,
  `_ki` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_subject`
--

INSERT INTO `_subject` (`_idSub`, `_nameSub`, `_hsCC`, `_cc`, `_hsTH`, `_th`, `_hsBT`, `_bt`, `_hsKI`, `_ki`) VALUES
(1, 'Vat ly', 0.1, '8', 0.2, '8', 0.1, '9', 0.6, '5'),
(3, 'Vat ly 3', 0.1, '10', 0.2, '8', 0.2, '9', 0.5, '7');

-- --------------------------------------------------------

--
-- Table structure for table `_timetable`
--

CREATE TABLE `_timetable` (
  `id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `week_num` int(2) NOT NULL,
  `lesson_id` int(15) NOT NULL,
  `note` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `_timetable`
--

INSERT INTO `_timetable` (`id`, `start_date`, `end_date`, `week_num`, `lesson_id`, `note`) VALUES
(1, '2018-12-02', '2018-12-09', 1, 1, ''),
(2, '2018-12-16', '2018-12-23', 1, 2, 'nulll');

-- --------------------------------------------------------

--
-- Table structure for table `_week`
--

CREATE TABLE `_week` (
  `_countWeek` int(11) NOT NULL,
  `_start` date NOT NULL,
  `_end` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `_lesson`
--
ALTER TABLE `_lesson`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `_message`
--
ALTER TABLE `_message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `student_id` (`student_id`);

--
-- Indexes for table `_student`
--
ALTER TABLE `_student`
  ADD PRIMARY KEY (`_idSV`);

--
-- Indexes for table `_subject`
--
ALTER TABLE `_subject`
  ADD PRIMARY KEY (`_idSub`);

--
-- Indexes for table `_timetable`
--
ALTER TABLE `_timetable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lesson_id` (`lesson_id`);

--
-- Indexes for table `_week`
--
ALTER TABLE `_week`
  ADD PRIMARY KEY (`_countWeek`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `_message`
--
ALTER TABLE `_message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `_timetable`
--
ALTER TABLE `_timetable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `_message`
--
ALTER TABLE `_message`
  ADD CONSTRAINT `_message_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `_student` (`_idSV`);

--
-- Constraints for table `_timetable`
--
ALTER TABLE `_timetable`
  ADD CONSTRAINT `_timetable_ibfk_1` FOREIGN KEY (`lesson_id`) REFERENCES `_lesson` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
