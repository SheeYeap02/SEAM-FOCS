DROP TABLE IF EXISTS `enquiry`;
DROP TABLE IF EXISTS `enquirer`;
DROP TABLE IF EXISTS `application`;
DROP TABLE IF EXISTS `preu_result`;
DROP TABLE IF EXISTS `qualification`;
DROP TABLE IF EXISTS `detailed_info`;
DROP TABLE IF EXISTS `emergency_info`;
DROP TABLE IF EXISTS `campus_assign`;
DROP TABLE IF EXISTS `career_assign`;
DROP TABLE IF EXISTS `progession_assign`;
DROP TABLE IF EXISTS `outline_assign`;
DROP TABLE IF EXISTS `programme_outline`;
DROP TABLE IF EXISTS `career`;
DROP TABLE IF EXISTS `campus`;
DROP TABLE IF EXISTS `progression`;
DROP TABLE IF EXISTS `programme`;
DROP TABLE IF EXISTS `profile_info`;
DROP TABLE IF EXISTS `staff`;
DROP TABLE IF EXISTS `applicant`;

------------------------------------------------------------------------------------------------------------------------------------
-- Create Statements
------------------------------------------------------------------------------------------------------------------------------------
-- User table
CREATE TABLE `applicant` (
	`applicant_id` BIGINT(20) NOT NULL,
    `applicant_email` VARCHAR(40) NOT NULL,
    `password` VARCHAR(64) NOT NULL,
    `registered_date` DATETIME NOT NULL,
    PRIMARY KEY (`applicant_id`),
    UNIQUE KEY `idx_applicant_email` (`applicant_email`)
);

-- Staff table
CREATE TABLE `staff` (
  `staff_id` BIGINT(20) NOT NULL,
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
    `profile_info_id` BIGINT(20) NOT NULL,
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
    `programme_id` BIGINT(20) NOT NULL,
    `programme_name` VARCHAR(50)  NOT NULL,
    `overview` VARCHAR(255)  NOT NULL,
    `level_of_study` VARCHAR(30)  NOT NULL,
    `duration` INT(2)  NOT NULL,
    `intake` VARCHAR(16)  NOT NULL,
    `local_total_fee` DECIMAL(10,2) NOT NULL,
    `oversea_total_fee` DECIMAL(10,2) NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`programme_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- Career table
CREATE TABLE `career` (
    `career_id` BIGINT(20) NOT NULL,
    `career_name` VARCHAR(30)  NOT NULL,
    PRIMARY KEY(`career_id`)
);

-- Progression table
CREATE TABLE `progression` (
    `progression_id` BIGINT(20) NOT NULL,
    `programme_name` VARCHAR(50)  NOT NULL,
    PRIMARY KEY(`progression_id`)
);

-- Campus table
CREATE TABLE `campus` (
    `campus_id` BIGINT(20) NOT NULL,
    `campus_name` VARCHAR(40) NOT NULL,
    PRIMARY KEY(`campus_id`)
);

-- ProgrammeOutline table
CREATE TABLE `programme_outline` (
    `programme_outline_id` BIGINT(20)  NOT NULL,
    `course_name` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`programme_outline_id`)
);

-- OutlineAssign table
CREATE TABLE `outline_assign` (
    `programme_id` BIGINT(20)  NOT NULL,
    `programme_outline_id` BIGINT(20)  NOT NULL,
    `is_elective` BOOLEAN  NOT NULL,
    `elective_no` INT(2) ,
    PRIMARY KEY (`programme_id`, `programme_outline_id`),
    FOREIGN KEY (`programme_id`) REFERENCES `programme`(`programme_id`),
    FOREIGN KEY (`programme_outline_id`) REFERENCES `programme_outline`(`programme_outline_id`)
);

-- ProgessionAssign table
CREATE TABLE `progession_assign` (
    `programme_id` BIGINT(20) NOT NULL,
    `progression_id` BIGINT(20) NOT NULL,
    `description` VARCHAR(150)  NOT NULL,
    PRIMARY KEY (`programme_id`, `progression_id`),
    FOREIGN KEY (`programme_id`) REFERENCES `programme`(`programme_id`),
    FOREIGN KEY (`progression_id`) REFERENCES `progression`(`progression_id`)
);

-- CareerAssign table
CREATE TABLE `career_assign` (
    `programme_id` BIGINT(20) NOT NULL,
    `career_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`programme_id`, `career_id`),
    FOREIGN KEY (`programme_id`) REFERENCES `programme`(`programme_id`),
    FOREIGN KEY (`career_id`) REFERENCES `career`(`career_id`)
);

-- CampusAssign table
CREATE TABLE `campus_assign` (
    `programme_id` BIGINT(20) NOT NULL,
    `campus_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`programme_id`, `campus_id`),
    FOREIGN KEY (`programme_id`) REFERENCES `programme`(`programme_id`),
    FOREIGN KEY (`campus_id`) REFERENCES `campus`(`campus_id`)
);

-- EmergencyInfo table
CREATE TABLE `emergency_info` (
    `emergency_info_id` BIGINT(20) NOT NULL,
    `fullName` VARCHAR(30)  NOT NULL,
    `relationship` VARCHAR(15)  NOT NULL,
    `address` VARCHAR(50)  NOT NULL,
    `postcode` VARCHAR(5)  NOT NULL,
    `state` VARCHAR(30)  NOT NULL,
    `country` VARCHAR(30)  NOT NULL,
    `contactNo` VARCHAR(14)  NOT NULL,
    `email` VARCHAR(40)  NOT NULL,
    `profile_info_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`emergency_info_id`),
    FOREIGN KEY (`profile_info_id`) REFERENCES `profile_info`(`profile_info_id`)
);

-- DetailedInfo table
CREATE TABLE `detailed_info` (
    `detailed_info_id` BIGINT(20) NOT NULL, 
    `ic_front` BLOB  NOT NULL,
    `ic_back` BLOB  NOT NULL,
    `household_income` DECIMAL(10, 2) NOT NULL,
    `medical_condition` VARCHAR(80) NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY(`detailed_info_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- Qualification table
CREATE TABLE `qualification` (
    `qualification_id` BIGINT(20) NOT NULL, 
    `start_date` DATETIME  NOT NULL,
    `end_date` DATETIME  NOT NULL,
    `mode_of_study` VARCHAR(20)  NOT NULL,
    `institution_name` VARCHAR(60)  NOT NULL,
    `institution_location` VARCHAR(50)  NOT NULL,
    `qualification_type` VARCHAR(25)  NOT NULL,
    `cgpa` DECIMAL(5, 4)  NOT NULL,
    `language_of_instruction` VARCHAR(20)  NOT NULL,
    `academic_certificate` BLOB  NOT NULL,
    `academic_transcript` BLOB  NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`qualification_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- PreUResult table
CREATE TABLE `preu_result` (
    `subject` VARCHAR(25) NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    `grade` VARCHAR(3)  NOT NULL,
    PRIMARY KEY (`subject`, `applicant_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`)
);

-- Application table
CREATE TABLE `application` (
    `application_id` BIGINT(20) NOT NULL,
    `intake` VARCHAR(12) NOT NULL,
    `application_status` VARCHAR(15) NOT NULL,
    `study_mode` VARCHAR(20) NOT NULL,
    `start_year` INT(4) NOT NULL,
    `campus_id` BIGINT(20) NOT NULL,
    `programme_id` BIGINT(20) NOT NULL,
    `profile_info_id` BIGINT(20) NOT NULL,
    `detailed_info_id` BIGINT(20) NOT NULL,
    `qualification_id` BIGINT(20) NOT NULL,
    `applicant_id` BIGINT(20) NOT NULL,
    `staff_id` BIGINT(20),
    PRIMARY KEY (`application_id`),
    FOREIGN KEY (`campus_id`) REFERENCES `campus`(`campus_id`),
    FOREIGN KEY (`programme_id`) REFERENCES `programme`(`programme_id`),
    FOREIGN KEY (`profile_info_id`) REFERENCES `profile_info`(`profile_info_id`),
    FOREIGN KEY (`detailed_info_id`) REFERENCES `detailed_info`(`detailed_info_id`),
    FOREIGN KEY (`qualification_id`) REFERENCES `qualification`(`qualification_id`),
    FOREIGN KEY (`applicant_id`) REFERENCES `applicant`(`applicant_id`),
    FOREIGN KEY (`staff_id`) REFERENCES `staff`(`staff_id`)
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
    `enquiry_id` BIGINT(20) NOT NULL,
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


------------------------------------------------------------------------------------------------------------------------------------
-- Insert Statements
------------------------------------------------------------------------------------------------------------------------------------
-- Users table
-- (UserEmail, Password, RegisteredDate)
INSERT INTO `applicant` VALUES (1, 'johndoe@gmail.com', '482c811da5d5b4bc6d497ffa98491e38', '2023-03-08');
INSERT INTO `applicant` VALUES (2,'janedoe@gmail.com', 'password456', '2023-03-09');

-- Staff table
-- (StaffId, Username, Password, StaffName, StaffContact, StaffEmail, StaffPosition, StaffRole, ResearchArea)
INSERT INTO `staff` VALUES (1, 'admin', 'password123', 'Ali Baba', '0123456789', 'alibaba@gmail.com', 'Dean', 'Administration', 'Computer Science');
INSERT INTO `staff` VALUES (2, 'staff', 'password456', 'Ali Mama', '0123456780', 'alimama@gmail.com', 'Lecturer', 'Teaching', 'Mathematics');

-- ProfileInfo table
INSERT INTO `profile_info` VALUES (1, 'John Doe', '123456789012', 'Malaysian', '1990-01-01', 'M', 'Divorcee', 'Chinese', 'Buddhist', '123 Main Street', '50000', 'WILAYAH PERSEKUTUAN, KUALA LUMPUR', 'Malaysia', '0312345678', '0123456789', 1);
INSERT INTO `profile_info` VALUES (2, 'Jane Doe', '987654321009', 'Malaysian', '1991-02-02', 'F', 'Married', 'Malay', 'Islam', '456 Main Street', '50000', 'WILAYAH PERSEKUTUAN, KUALA LUMPUR', 'Malaysia', '0312345670', '0123456780', 2);

-- Programme table
-- (ProgrammeId, ProgrammeName, Overview, LevelOfStudy, Duration, Intake, localTotalFee, overseaTotalFee, ApplicantId)
INSERT INTO `programme` VALUES (1, 'Bachelor of Computer Science', 'A 3-year programme that prepares students for a career in computer science.', 'Undergraduate', 3, '2023/2024', '20000', '30000', 1);
INSERT INTO `programme` VALUES (2, 'Master of Business Administration', 'A 2-year programme that prepares students for a career in business administration.', 'Postgraduate', 2, '2023/2024', '18000', '28000', 2);

-- Career table
-- (CareerId, CareerName)
INSERT INTO `career` VALUES (1, 'Software Engineer');
INSERT INTO `career` VALUES (2, 'Data Scientist');

-- Progression table
-- (ProgressionId, ProgrammeName)
INSERT INTO `progression` VALUES (1, 'Bachelor of Computer Science (Honours)');
INSERT INTO `progression` VALUES (2, 'Master of Business Administration (MBA)');

-- Campus table
-- (CampusId, CampusName)
INSERT INTO `campus` VALUES (1, 'Kuala Lumpur Campus');
INSERT INTO `campus` VALUES (2, 'Penang Campus');

-- ProgrammeOutline table
-- (ProgrammeOutlineId, CourseName)
INSERT INTO `programme_outline` VALUES (1, 'Introduction to Computer Science');
INSERT INTO `programme_outline` VALUES (2, 'Data Structures and Algorithms');

-- OutlineAssign table
-- (ProgrammeId, ProgrammeOutlineId, IsElective, ElectiveNo)
INSERT INTO `outline_assign` VALUES (1, 1, 0, 1);
INSERT INTO `outline_assign` VALUES (1, 2, 1, 2);

-- ProgessionAssign table
-- (ProgrammeId, ProgressionId, Description)
INSERT INTO `progession_assign` VALUES (1, 1, 'A 1-year programme that allows students to specialize in a particular area of computer science.');
INSERT INTO `progession_assign` VALUES (2, 2, 'A 1-year programme that allows students to specialize in a particular area of business administration.');

-- CareerAssign table
-- (ProgrammeId, CareerId)
INSERT INTO `career_assign` VALUES (1, 1);
INSERT INTO `career_assign` VALUES (2, 2);

-- CampusAssign table
-- (ProgrammeId, CampusId)
INSERT INTO `campus_assign` VALUES (1, 1);
INSERT INTO `campus_assign` VALUES (1, 2);
INSERT INTO `campus_assign` VALUES (2, 1);

-- EmergencyInfo table
-- (EmergencyInfoId, FullName, Relationship, Address, Postcode, State, Country, ContactNo, Email, ProfileInfoId)
INSERT INTO `emergency_info` VALUES (1, 'John Smith', 'Father', '123 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0123456789', 'john.smith@gmail.com', 1);
INSERT INTO `emergency_info` VALUES (2, 'Jane Doe', 'Mother', '456 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0123456780', 'jane.doe@gmail.com', 2);

-- DetailedInfo table
-- (DetailedInfoId, ICFront, ICBack, HouseholdIncome, MedicalCondition, ApplicantId)
INSERT INTO `detailed_info` VALUES (1, '123456789012.jpg', '987654321009.jpg', 50000, 'None', 1);
INSERT INTO `detailed_info` VALUES (2, '456789012345.jpg', '678901234567.jpg', 80000, 'Asthma', 2);

-- Qualification table
-- (QualificationId, StartDate, EndDate, ModeOfStudy, InstitutionName, InstitutionLocation, QualificationType, CGPA, LanguageOfInstruction, AcademicCertificate, AcademicTranscript, ApplicantId)
INSERT INTO `qualification` VALUES (1, '2019-01-01', '2022-12-31', 'Full-time', 'University of Malaya', 'Kuala Lumpur', 'Degree', 3.8, 'English', 'certificate.pdf', 'transcript.pdf', 1);
INSERT INTO `qualification` VALUES (2, '2017-01-01', '2019-12-31', 'Part-time', 'Tunku Abdul Rahman University College', 'Penang', 'Diploma', 3.5, 'Malay', 'certificate.pdf', 'transcript.pdf', 2);

-- PreUResult table
-- (Subject, ApplicantId, Grade)
INSERT INTO `preu_result` VALUES ('Mathematics', 1, 'A');
INSERT INTO `preu_result` VALUES ('Physics', 1, 'B');
INSERT INTO `preu_result` VALUES ('Chemistry', 1, 'A');

-- Application table
-- (ApplicationId, Intake, ApplicationStatus, StudyMode, StartYear, CampusId, ProgrammeId, ProfileInfoId, DetailedInfoId, QualificationId, ApplicantId, StaffId)
INSERT INTO `application` VALUES (1, '2023/2024', 'Pending', 'Full-time', '2023', 1, 1, 1, 1, 1, 1, 2);
INSERT INTO `application` VALUES (2, '2023/2024', 'Pending', 'Part-time', '2023', 2, 2, 2, 2, 2, 2, 1);

-- Enquirer table
-- (EnquirerEmail, Contact, Name, Nationality)
INSERT INTO `enquirer` VALUES ('enquiry@gmail.com', '0123456789', 'John Doe', 'Malaysian');

-- Enquiry table
-- (EnquiryId, HighestLvlEduc, ProgrammeLvlInterest, ProgrammeInterest, Question, Reply, EnquiryStatus, EnquirerEmail, StaffId)
INSERT INTO `enquiry` VALUES (1, 'STPM', 'Undergraduate', 'Bachelor of Computer Science', 'What are the admission requirements for the Bachelor of Computer Science programme?', 'The admission requirements for the Bachelor of Computer Science programme are:

* SPM with a minimum of 5 credits in Mathematics, Physics, and Chemistry.
* A Diploma in Computer Science or a related field.
* An equivalent qualification recognized by the University.

The application deadline is 31 March 2023.', 'Pending', 'enquiry@gmail.com', 1);







