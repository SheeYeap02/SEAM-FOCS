DROP TABLE IF EXISTS `query`;
DROP TABLE IF EXISTS `enquiry`;
DROP TABLE IF EXISTS `enquirer`;
DROP TABLE IF EXISTS `application`;
DROP TABLE IF EXISTS `preu_result`;
DROP TABLE IF EXISTS `qualification`;
DROP TABLE IF EXISTS `detailed_info`;
DROP TABLE IF EXISTS `emergency_info`;
DROP TABLE IF EXISTS `intake`;
DROP TABLE IF EXISTS `programme`;
DROP TABLE IF EXISTS `profile_info`;
DROP TABLE IF EXISTS `staff`;
DROP TABLE IF EXISTS `query`;
DROP TABLE IF EXISTS `applicant`;


------------------------------------------------------------------------------------------------------------------------------------
-- Create Statements
------------------------------------------------------------------------------------------------------------------------------------
-- User table
CREATE TABLE `applicant` (
	`applicant_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `applicant_email` VARCHAR(40) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `registered_date` DATETIME NOT NULL,
    PRIMARY KEY (`applicant_id`),
    UNIQUE KEY `idx_applicant_email` (`applicant_email`)
);

-- Staff table
CREATE TABLE `staff` (
  `staff_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(15) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `staff_name` VARCHAR(30) NOT NULL,
  `staff_contact` VARCHAR(14) NOT NULL,
  `staff_email` VARCHAR(30) NOT NULL,
  `staff_position` VARCHAR(25) NOT NULL,
  `staff_role` VARCHAR(25) NOT NULL,
  `research_area` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`staff_id`)
);

-- ProfileInfoId table
CREATE TABLE `profile_info` (
    `profile_info_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `full_name` VARCHAR(30)  NOT NULL,
    `mykad_no` VARCHAR(14)  NOT NULL,
    `nationality` VARCHAR(30)  NOT NULL,
    `date_of_birth` DATETIME  NOT NULL,
    `gender` VARCHAR(1)  NOT NULL,
    `marital_status` VARCHAR(20)  NOT NULL,
    `race` VARCHAR(20)  NOT NULL,
    `religion` VARCHAR(30)  NOT NULL,
    `address` VARCHAR(50)  NOT NULL,
    `postcode` VARCHAR(5)  NOT NULL,
    `state` VARCHAR(50)  NOT NULL,
    `country` VARCHAR(50)  NOT NULL,
    `home_tel_no` VARCHAR(14)  NOT NULL,
    `mobile_no` VARCHAR(14)  NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`profile_info_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- Programme table
CREATE TABLE `programme` (
    `programme_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `programme_name` VARCHAR(50)  NOT NULL,
    `overview` VARCHAR(255)  NOT NULL,
    `level_of_study` VARCHAR(30)  NOT NULL,
    `duration` INT(2)  NOT NULL,
    `intake` VARCHAR(16)  NOT NULL,
    `Campus` VARCHAR(255)  NOT NULL,
    `Progression` VARCHAR(255)  NOT NULL,
    `Career` VARCHAR(255) NOT NULL,
    `local_total_fee` DECIMAL(10,2) NOT NULL,
    `oversea_total_fee` DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(`programme_id`)
);

-- Intake table
CREATE TABLE `intake` (
    `intake_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `session` VARCHAR(20)  NOT NULL,
    `campus` VARCHAR(40)  NOT NULL,
    `level_of_study` VARCHAR(30) NOT NULL,
    `entry_qualification` VARCHAR(80) ,
    `programme` VARCHAR(80) NOT NULL,
    `first_sem` VARCHAR(20)  ,
    `priority` INT(2)  NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`intake_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- EmergencyInfo table
CREATE TABLE `emergency_info` (
    `emergency_info_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `full_name` VARCHAR(30)  NOT NULL,
    `relationship` VARCHAR(15)  NOT NULL,
    `address` VARCHAR(50)  NOT NULL,
    `postcode` VARCHAR(5)  NOT NULL,
    `state` VARCHAR(50)  NOT NULL,
    `country` VARCHAR(30)  NOT NULL,
    `contact_no` VARCHAR(14)  NOT NULL,
    `email` VARCHAR(40)  NOT NULL,
    `profile_info_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`emergency_info_id`),
    FOREIGN KEY (`profile_info_id`) REFERENCES `profile_info`(`profile_info_id`)
);

-- DetailedInfo table
CREATE TABLE `detailed_info` (
    `detailed_info_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `ic_image` longblob  ,
    `household_income` VARCHAR(40) NOT NULL,
    `medical_condition` VARCHAR(150) NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`detailed_info_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- Qualification table
CREATE TABLE `qualification` (
    `qualification_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `year` INT(4) NOT NULL,
    `category` VARCHAR(150) NOT NULL,
    `type` VARCHAR(35) ,
    `academic_prove` longblob  ,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`qualification_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- PreUResult table
CREATE TABLE `preu_result` (
	`result_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `subject` VARCHAR(80) NOT NULL,
    `qualification_id` BIGINT(20) NOT NULL,
    `grade` VARCHAR(3)  NOT NULL,
	`result_type` VARCHAR(35) ,
    PRIMARY KEY (`result_id`),
    FOREIGN KEY (`qualification_id`) REFERENCES `qualification`(`qualification_id`)
);

-- Application table
CREATE TABLE `application` (
    `application_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `status` VARCHAR(15) NOT NULL,
    `created_date` DATETIME NOT NULL,
    `submitted_date` DATETIME,
    `intake_id` BIGINT(20),
    `profile_info_id` BIGINT(20) ,
    `detailed_info_id` BIGINT(20) ,
    `qualification_id` BIGINT(20) ,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`application_id`),
    FOREIGN KEY (`intake_id`) REFERENCES `intake`(`intake_id`),
    FOREIGN KEY (`profile_info_id`) REFERENCES `profile_info`(`profile_info_id`),
    FOREIGN KEY (`detailed_info_id`) REFERENCES `detailed_info`(`detailed_info_id`),
    FOREIGN KEY (`qualification_id`) REFERENCES `qualification`(`qualification_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);


-- Enquirer table
CREATE TABLE `enquirer`(
    `enquirer_email` VARCHAR(30),
    `contact` VARCHAR(14)  NOT NULL,
    `name` VARCHAR(30)  NOT NULL,
    `nationality` VARCHAR(30)  NOT NULL,
    PRIMARY KEY (`enquirer_email`)
);

-- Enquiry table
CREATE TABLE `enquiry`(
    `enquiry_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `highest_lvl_educ` VARCHAR(30) NOT NULL,
    `programme_lvl_interest` VARCHAR(40)  NOT NULL,
    `programme_interest` VARCHAR(40)  NOT NULL,
    `question` VARCHAR(200)  NOT NULL,
    `reply` TEXT(2000)  NOT NULL,
    `enquiry_status` VARCHAR(25)  NOT NULL,
    `enquirer_email` VARCHAR(30) NOT NULL,
    `staff_id` BIGINT(20) ,
    PRIMARY KEY (`enquiry_id`),
    FOREIGN KEY (`enquirer_email`) REFERENCES `enquirer`(`enquirer_email`),
    FOREIGN KEY (`staff_id`) REFERENCES `staff`(`staff_id`)
);

-- Query Table
CREATE TABLE `query`(
	`applicant_id` BIGINT(50) NOT NULL,
    `query_id` BIGINT(20) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `question` VARCHAR(200)  NOT NULL,
    `reply` TEXT(2000),
    `query_status` VARCHAR(25)  NOT NULL,
    `created` DATETIME NOT NULL,
    `completed` DATETIME,
    primary key(`query_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);


------------------------------------------------------------------------------------------------------------------------------------
-- Insert Statements
------------------------------------------------------------------------------------------------------------------------------------
-- Users table
-- (UserEmail, Password, RegisteredDate)
INSERT INTO `applicant` VALUES (1, 'johndoe@gmail.com', '482c811da5d5b4bc6d497ffa98491e38', '2023-03-08');
INSERT INTO `applicant` VALUES (2,'janedoe@gmail.com', '96b33694c4bb7dbd07391e0be54745fb', '2023-03-09');

-- Staff table
-- (StaffId, Username, Password, StaffName, StaffContact, StaffEmail, StaffPosition, StaffRole, ResearchArea)
INSERT INTO `staff` VALUES (1, 'admin', 'password123', 'Ali Baba', '0123456789', 'alibaba@gmail.com', 'Dean', 'Administration', 'Computer Science');
INSERT INTO `staff` VALUES (2, 'staff', 'password456', 'Ali Mama', '0123456780', 'alimama@gmail.com', 'Lecturer', 'Teaching', 'Mathematics');

-- ProfileInfo table
INSERT INTO `profile_info` VALUES (1, 'John Doe', '123456789012', 'Malaysian', '1990-01-01', 'M', 'Divorcee', 'Chinese', 'Buddhist', '123 Main Street', '50000', 'WILAYAH PERSEKUTUAN KUALA LUMPUR', 'Malaysia', '0312345678', '0123456789', 1);
INSERT INTO `profile_info` VALUES (2, 'Jane Doe', '987654321009', 'Malaysian', '1991-02-02', 'F', 'Married', 'Malay', 'Islam', '456 Main Street', '50000', 'WILAYAH PERSEKUTUAN KUALA LUMPUR', 'Malaysia', '0312345670', '0123456780', 2);

-- Programme table
-- (ProgrammeId, ProgrammeName, Overview, LevelOfStudy, Duration, Intake, localTotalFee, overseaTotalFee, ApplicantId)
INSERT INTO `programme` VALUES (1, 'Bachelor of Computer Science', 'Students are trained in both theoretical knowledge and practical skills for software development, system design and related mathematical techniques. ', 'Diploma', 2, '2023/2024', 'KL - Kuala Lumpur Main Campus, PG - Penang Branch Campus,JH - Johor Branch Campus','Bachelor of Science (Honours) in Management Mathematics with Computing,Bachelor of Software Engineering (Honours),Bachelor of Computer Science (Honours) in Interactive Software Technology,Bachelor of Computer Science (Honours) in Data Science','Junior Analyst Programmers,Junior Systems Analysts,Junior Software Engineers,Junior Systems Engineers,Junior Research Officers,Junior Quantitative Analysts,Junior Software Developers', 20000, 30000);
INSERT INTO `programme` VALUES (2, 'Diploma in Information Systems', 'This program majors in business information systems. It aims to produce graduates with fundamental knowledge in information technology and its business-related applications.', 'Diploma', 2, '2023/2024', 'KL - Kuala Lumpur Main Campus, PG - Penang Branch Campus,JH - Johor Branch Campus','Bachelor of Information Systems (Honours) in Enterprise Information Systems','Junior Programmers,Junior Systems Analysts,Junior SAP Support Consultants,Junior IT Support Executives,Junior IT Executives', 20000, 30000);

-- Intake table
INSERT INTO `intake`  VALUES ('1', 'Oct/Nov 2023','KUALA LUMPUR CAMPUS','DIPLOMA','SPM/O LEVEL/UEC/EQUIVALENT','DIPLOMA IN ACCOUNTING','Year 1 Sem 1', 1, 1);
INSERT INTO `intake`  VALUES ('2', 'Oct/Nov 2023','KUALA LUMPUR CAMPUS','DIPLOMA','TAR UMT CERTIFICATE','DIPLOMA IN ACCOUNTING','Year 1 Sem 1', 2, 1);
INSERT INTO `intake`  VALUES ('3', 'Oct/Nov 2023','KUALA LUMPUR CAMPUS','DIPLOMA','OTHER INSTITUTION OF HIGHER LEARNING CERTIFICATE/EQUIVALENT','DIPLOMA IN ACCOUNTING','Year 1 Sem 1', 3, 1);


-- EmergencyInfo table
-- (EmergencyInfoId, FullName, Relationship, Address, Postcode, State, Country, ContactNo, Email, ProfileInfoId)
INSERT INTO `emergency_info` VALUES (1, 'John Smith', 'Father', '123 Main Street', '50000', 'WILAYAH PERSEKUTUAN KUALA LUMPUR', 'Malaysia', '0123456789', 'john.smith@gmail.com', 1);
INSERT INTO `emergency_info` VALUES (2, 'Jane Doe', 'Mother', '456 Main Street', '50000', 'WILAYAH PERSEKUTUAN KUALA LUMPUR', 'Malaysia', '0123456780', 'jane.doe@gmail.com', 2);

-- DetailedInfo table
-- (DetailedInfoId, ICFront, ICBack, HouseholdIncome, MedicalCondition, ApplicantId)
INSERT INTO `detailed_info` VALUES (1, '123456789012.jpg', 'T20 (RM9001 and above)', 'Asthma', 1);
INSERT INTO `detailed_info` VALUES (2, '456789012345.jpg', 'M40 (RM5001 to RM9000)', 'No', 2);

-- Qualification table
-- (QualificationId, Year, QualificationType, CGPA, LanguageOfInstruction, AcademicCertificate, AcademicTranscript, ApplicantId)
INSERT INTO `qualification` VALUES (1, '2019', 'SPM/O LEVEL/EQUIVALENT', 'SPM', 'certificate.pdf', 1);
INSERT INTO `qualification` VALUES (2, '2020', 'STPM/A LEVEL/ UEC/EQUIVALENT (IF APPLICABLE)', 'STPM', 'transcript.pdf', 2);

-- PreUResult table
-- (Subject, ApplicantId, Grade)
INSERT INTO `preu_result` VALUES (1, 'MATHEMATICS', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (2, 'PHYSICS', 1, 'B', 'SPM');
INSERT INTO `preu_result` VALUES (3, 'CHEMISTRY', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (4, 'BIOLOGY', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (5, 'ADDITIONAL MATHEMATICS', 1, 'B', 'SPM');
INSERT INTO `preu_result` VALUES (6, 'BAHASA CINA', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (7, 'BAHASA MELAYU', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (8, 'BAHASA INGGERIS', 1, 'A', 'SPM');
INSERT INTO `preu_result` VALUES (9, 'PENDIDIKAN MORAL', 1, 'B', 'SPM');
INSERT INTO `preu_result` VALUES (10, 'SEJARAH', 1, 'A', 'SPM');

-- Intake table
INSERT INTO `application`  VALUES ('1', 'Pending','2023-01-01','2023-01-01', 1, 1, 1, 1, 1);

-- Enquirer table
-- (EnquirerEmail, Contact, Name, Nationality)
INSERT INTO `enquirer` VALUES ('enquiry@gmail.com', '0123456789', 'John Doe', 'Malaysian');

-- Query table
-- (applicantId, queryId, question, message, queryStatus, created, completed)
INSERT INTO `query` VALUES(1, 1, 'title', 'question', 'message', 'pending', '2023-01-01', '2023-01-01');

-- Enquiry table
-- (EnquiryId, HighestLvlEduc, ProgrammeLvlInterest, ProgrammeInterest, Question, Reply, EnquiryStatus, EnquirerEmail, StaffId)
INSERT INTO `enquiry` VALUES (1, 'STPM', 'Undergraduate', 'Bachelor of Computer Science', 'What are the admission requirements for the Bachelor of Computer Science programme?', 'The admission requirements for the Bachelor of Computer Science programme are:


* SPM with a minimum of 5 credits in Mathematics, Physics, and Chemistry.
* A Diploma in Computer Science or a related field.
* An equivalent qualification recognized by the University.

The application deadline is 31 March 2023.', 'Pending', 'enquiry@gmail.com', 1);







