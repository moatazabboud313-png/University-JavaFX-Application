-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2023 at 07:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university`
--

-- --------------------------------------------------------

--
-- Table structure for table `assistantscourses`
--

CREATE TABLE `assistantscourses` (
  `assistant_id` char(10) DEFAULT NULL,
  `course_id` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assistantscourses`
--

INSERT INTO `assistantscourses` (`assistant_id`, `course_id`) VALUES
('5554442541', 'MT110'),
('5554442541', 'PH0100'),
('5553332254', 'PH0100'),
('5553332254', 'MT110'),
('5553332254', 'PH0030'),
('5551112523', 'PH119'),
('5551112523', 'PH0030'),
('5551112536', 'PH119'),
('5551112536', 'PH0030'),
('5552221555', 'CH106'),
('5552221555', 'CH311'),
('5552222536', 'CH106'),
('5552222536', 'CH311');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `Code` varchar(6) NOT NULL,
  `CreditHours` int(11) DEFAULT NULL,
  `Name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Code`, `CreditHours`, `Name`) VALUES
('CH106', 3, 'Physical Chem'),
('CH202D', 2, 'InOrganic'),
('CH240', 2, 'Organic2'),
('CH301', 3, 'Organic1'),
('CH311', 2, 'InOrganic Pract'),
('CS101', 2, 'Java'),
('CS107', 2, 'Advanced'),
('CS109', 3, 'OOP'),
('CS110', 3, 'Machine Learning'),
('CS161', 1, 'Javafx'),
('CS276', 2, 'Ai'),
('CS50', 3, 'DataBase'),
('MT102', 3, 'Math2'),
('MT103', 2, 'Statistics'),
('MT109', 2, 'Mechanics1'),
('MT110', 2, 'Math1'),
('MT162', 3, 'Mechanics2'),
('PH0030', 2, 'Electricity'),
('PH0100', 2, 'Heat'),
('PH030', 1, 'Modern Pract'),
('PH040', 3, 'Modern'),
('PH101', 2, 'Physics1'),
('PH102', 3, 'Physics2'),
('PH119', 3, 'Optics');

-- --------------------------------------------------------

--
-- Table structure for table `employers`
--

CREATE TABLE `employers` (
  `Name` varchar(30) NOT NULL,
  `Id` char(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `NationalId` char(14) NOT NULL,
  `Salary` float NOT NULL,
  `WorkingHours` int(1) NOT NULL,
  `Position` varchar(30) NOT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employers`
--

INSERT INTO `employers` (`Name`, `Id`, `Age`, `NationalId`, `Salary`, `WorkingHours`, `Position`, `Email`) VALUES
('Ahmed Ehab', '7775552136', 45, '77777777777777', 9000, 5, 'Manager', 'ahmedehab@gmail.com'),
('Jimmy Crolos', '7775554252', 39, '77777777777777', 6000, 4, 'It', 'jimmycrolos@gmail.com'),
('Samia Elhady', '7779996232', 40, '88888888888888', 7000, 7, 'Co-Manager', 'samiaelhady@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `professors`
--

CREATE TABLE `professors` (
  `Name` varchar(30) NOT NULL,
  `Id` char(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `NationalId` char(14) NOT NULL,
  `Salary` float NOT NULL,
  `MajorDepartment` varchar(20) NOT NULL,
  `Office` varchar(20) NOT NULL,
  `Lecture` varchar(20) NOT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Course` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `professors`
--

INSERT INTO `professors` (`Name`, `Id`, `Age`, `NationalId`, `Salary`, `MajorDepartment`, `Office`, `Lecture`, `Email`, `Course`) VALUES
('Mohammed Ibrahim', '3332221415', 55, '44444444444444', 10000, 'Mathematics', 'Office 1 MT', 'Math1 3pm Sun', 'mohamedibrahim@gmail.com', 'MT110'),
('Khaled El-Sayed', '3332223584', 41, '33333333333333', 15000, 'CS', 'Office 3 CS', 'Ai 4pm Sun', 'khaledelsayed@gmail.com', 'CS276'),
('Ail Samy', '3332226562', 35, '44444444444444', 11000, 'CS', 'Office 2 CS', 'OOP 9am Wed', 'alisamy@gmail.com', 'CS109'),
('Ahmed Sameeh', '3332226569', 35, '33333333333333', 10000, 'CS', 'Office 1 CS', 'Java 2PM Tue', 'ahmedsameeh@gmail.com', 'CS101'),
('Nehal Ahmed', '3334442178', 42, '44444444444444', 20000, 'Mathematics', 'Office 3 MT', 'Mec 1pm Wed', 'nehalahmed@gmail.com', 'MT109'),
('Amira Ali', '3334444566', 39, '44444444444444', 10000, 'Physics', 'Office 2 PH', 'Phy2 9am Sun', 'amiraali@gmail.com', 'PH102'),
('Ahmed Radi', '3334446258', 38, '33333333333333', 16000, 'Mathematics', 'Office 2 MT', 'Math2 7am Sat', 'ahmedradi@gmail.com', 'MT102'),
('Hossam Gaber', '3334446958', 49, '33333333333333', 22000, 'Physics', 'Office 1 PH', 'Phy1 3pm Fri', 'gossamgaber@gmail.com', 'PH101'),
('Hani Gamal', '3339991252', 43, '44444444444444', 19000, 'Chemistry', 'Office 1 CM', 'InOrg1 6pm Sun', 'hanigamal@gmail.com', 'CH202D'),
('Ahmed Zakaria', '3339992123', 37, '33333333333333', 25000, 'Chemistry', 'Office 2 CM', 'Org1 9am Trs', 'ahmedzakaria@gmail.com', 'CH301'),
('Laila Ahmed', '3339992525', 52, '33333333333333', 12000, 'Physics', 'Office 3 PH', 'Elc 2pm Sat', 'lailaahmed@gmail.com', 'PH0030'),
('Salma Emad', '3339995514', 39, '44444444444444', 23000, 'Chemistry', 'Office 3 CM', 'Org2 4pm Tra', 'salmaemad@gmail.com', 'CH240');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `Name` varchar(30) NOT NULL,
  `Id` char(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `NationalId` int(14) NOT NULL,
  `Salary` float NOT NULL,
  `WorkingHours` int(1) NOT NULL,
  `Type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `studentcourses`
--

CREATE TABLE `studentcourses` (
  `student_id` char(10) DEFAULT NULL,
  `course_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentcourses`
--

INSERT INTO `studentcourses` (`student_id`, `course_id`) VALUES
('1115552452', 'CS101'),
('1115552452', 'CS109'),
('1115552452', 'CS276'),
('1115552452', 'CS109'),
('1115553362', 'PH0100'),
('1115553362', 'PH030'),
('1115553362', 'PH040'),
('1115553362', 'PH102'),
('1115553362', 'MT103'),
('1115553362', 'MT102'),
('1115553362', 'MT110'),
('1115556958', 'PH0100'),
('1115556958', 'PH030'),
('1115556958', 'PH040'),
('1115556958', 'PH102'),
('1115556958', 'MT103'),
('1115556958', 'MT102'),
('1115556262', 'PH0100'),
('1115556262', 'PH030'),
('1115556262', 'PH040'),
('1115556262', 'PH102'),
('1115556262', 'MT103'),
('1115556262', 'MT102'),
('1115552452', 'CH202D'),
('1115552452', 'CH240'),
('1115552452', 'CH311'),
('1115556141', 'PH101');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Name` varchar(30) NOT NULL,
  `Id` char(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `NationalId` char(14) NOT NULL,
  `Cgpa` float NOT NULL,
  `MajorDepartment` varchar(20) NOT NULL,
  `MinorDepartment` varchar(20) NOT NULL,
  `StudyLevel` int(1) NOT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Name`, `Id`, `Age`, `NationalId`, `Cgpa`, `MajorDepartment`, `MinorDepartment`, `StudyLevel`, `Email`) VALUES
('Samira Khalil', '1112223636', 18, '11111111111111', 3.2, 'CS', 'CS', 4, 'samirakhalil@gmail.com'),
('Mera Ahmed', '1115552452', 20, '11111111111111', 4, 'CS', 'Mathematics', 2, 'meraahmed@gmail.com'),
('Samir Alaa', '1115553362', 20, '11111111111111', 3.2, 'Physics', 'Mathematics', 1, 'samiralaa@gmail.com'),
('Ahmed Mohamed', '1115553620', 18, '22222222222222', 3.2, 'CS', 'CS', 2, 'ahmedmohamed@gmail.com\n'),
('Sara Khaled', '1115553626', 19, '22222222222222', 3.7, 'Chemistry', 'CS', 1, 'sarakhaled@gmail.com'),
('Ahmed Khamis', '1115556125', 18, '22222222222222', 3, 'Chemistry', 'Physics', 2, 'ahmedkhamis@gmail.com'),
('Bassem Hazem', '1115556141', 20, '22222222222222', 3.2, 'CS', 'Mathematics', 3, 'bassemhazem@gmail.com'),
('Ahmed Khalid', '1115556262', 18, '22222222222222', 3.2, 'CS', 'CS', 2, 'ahmedkhalid@gmail.com'),
('Ali Ossama', '1115556958', 17, '11111111111111', 4, 'Physics', 'Mathematics', 2, 'aliossama@gmail.com'),
('Dalia Mahmoud', '1115559412', 19, '11111111111111', 1.7, 'Chemistry', 'CS', 3, 'daliamohamed@gmail.com'),
('Amir Shaban', '1116663626', 20, '11111111111111', 2.5, 'CS', 'Physics', 3, 'amirshaban@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `teachingassistants`
--

CREATE TABLE `teachingassistants` (
  `Name` varchar(30) NOT NULL,
  `Id` char(10) NOT NULL,
  `Age` int(2) NOT NULL,
  `NationalId` char(14) NOT NULL,
  `Salary` float NOT NULL,
  `MajorDepartment` varchar(20) NOT NULL,
  `Room` varchar(10) NOT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teachingassistants`
--

INSERT INTO `teachingassistants` (`Name`, `Id`, `Age`, `NationalId`, `Salary`, `MajorDepartment`, `Room`, `Email`) VALUES
('Alaa Khaled', '5551112523', 27, '66666666666666', 4000, 'Physics', 'Room3', 'alaakhaled@gmail.com'),
('Assmaa Ibrahim', '5551112536', 30, '66666666666666', 5000, 'Physics', 'Room3', 'assmaaibrahim@gmail.com'),
('Nour Khalid', '5552221555', 32, '66666666666666', 4500, 'Chemistry', 'Room4', 'nourkhalid@gmail.com'),
('Mohammed Ali', '5552222523', 27, '66666666666666', 4000, 'Chemistry', 'Room4', 'mohamedali@gmail.com'),
('Sara Awad', '5552222536', 30, '66666666666666', 5000, 'Chemistry', 'Room4', 'saraawad@gmail.com'),
('Eman Ali', '5553332254', 30, '66666666666666', 5000, 'CS', 'Room1', 'emanali@gmail.com'),
('Sherif Ahmed', '5553335158', 32, '66666666666666', 4500, 'CS', 'Room1', 'sherifahmed@gmail.com'),
('Amira Abd-Allah', '5553335621', 30, '55555555555555', 3500, 'CS', 'Room1', 'amiraabdallah@gmail.com'),
('Dalia Ibrahim', '5554442541', 32, '55555555555555', 3000, 'Chemistry', 'Room4', 'daliaibrahim@gmail.com'),
('Samir Mohammed', '5554445622', 27, '55555555555555', 4000, 'Chemistry', 'Room4', 'samirmohamed@gmail.com'),
('Amir Mahmoud', '5556666259', 27, '66666666666666', 4000, 'CS', 'Room1', 'amirmahmoud@gmail.com'),
('Rana Khamis', '5556669568', 32, '55555555555555', 3000, 'CS', 'Room1', 'ranakhamis@gmail.com'),
('Bassem Youssef', '5556669825', 28, '55555555555555', 3000, 'CS', 'Room1', 'bassemyoussef@gmail.com'),
('Sali Khalil', '5557775621', 30, '55555555555555', 3500, 'Mathematics', 'Room2', 'salikhalil@gmail.com'),
('Sayed Hosny', '5557777259', 27, '55555555555555', 4000, 'Mathematics', 'Room2', 'sayedhosny@gmail.com'),
('Noran Mahmoud', '5557779568', 32, '55555555555555', 3000, 'Mathematics', 'Room2', 'notanmahmoud@gmail.com'),
('Samia Hassan', '5558882254', 30, '66666666666666', 5000, 'Mathematics', 'Room2', 'samiahassan@gmail.com'),
('Adel Hossam', '5558885158', 32, '66666666666666', 4500, 'Mathematics', 'Room2', 'adelhossam@gmail.com'),
('Tamer Ragab', '5558888259', 27, '66666666666666', 4000, 'Mathematics', 'Room2', 'tamerragab@gmail.com'),
('Talia Sayed', '5559991555', 32, '66666666666666', 4500, 'Physics', 'Room3', 'talyasayed@gmail.com'),
('Samira Khalil', '5559992541', 32, '55555555555555', 3000, 'Physics', 'Room3', 'samirakhalil@gmail.com'),
('Mostafa Saad', '5559995621', 27, '55555555555555', 4000, 'Physics', 'Room3', 'mostafasaad@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Code`);

--
-- Indexes for table `employers`
--
ALTER TABLE `employers`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `teachingassistants`
--
ALTER TABLE `teachingassistants`
  ADD PRIMARY KEY (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
