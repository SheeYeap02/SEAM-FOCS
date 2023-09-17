---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Drop Table
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS Enquiry;
DROP TABLE IF EXISTS Enquirer;
DROP TABLE IF EXISTS Application;
DROP TABLE IF EXISTS PreUResult;
DROP TABLE IF EXISTS Qualification;
DROP TABLE IF EXISTS DetailedInfo;
DROP TABLE IF EXISTS EmergencyInfo;
DROP TABLE IF EXISTS CampusAssign;
DROP TABLE IF EXISTS CareerAssign;
DROP TABLE IF EXISTS ProgessionAssign;
DROP TABLE IF EXISTS OutlineAssign;
DROP TABLE IF EXISTS ProgrammeOutline;
DROP TABLE IF EXISTS EstimatedFee;
DROP TABLE IF EXISTS Career;
DROP TABLE IF EXISTS Campus;
DROP TABLE IF EXISTS Progression;
DROP TABLE IF EXISTS Programme;
DROP TABLE IF EXISTS ProfileInfo;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Users;

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Create Table
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- User table
CREATE TABLE Users (
    UserEmail VARCHAR(40),
    Password VARCHAR(20)NOT NULL,
    RegisteredDate DATE NOT NULL,
    PRIMARY KEY (UserEmail)
);

-- Staff table
CREATE TABLE Staff (
  StaffId BIGINT(20),
  Username VARCHAR(15) NOT NULL,
  Password VARCHAR(20) NOT NULL,
  StaffName VARCHAR(30) NOT NULL,
  StaffContact VARCHAR(14) NOT NULL,
  StaffEmail VARCHAR(30) NOT NULL,
  StaffPosition VARCHAR(25) NOT NULL,
  StaffRole VARCHAR(25) NOT NULL,
  ResearchArea VARCHAR(40) NOT NULL,
  PRIMARY KEY (StaffId)
);

-- ProfileInfoId table
CREATE TABLE ProfileInfo (
    ProfileInfoId BIGINT(20),
    FullName VARCHAR(30)  NOT NULL,
    ICNo VARCHAR(14)  NOT NULL,
    Nationality VARCHAR(30)  NOT NULL,
    DateOfBirth DATE  NOT NULL,
    Gender VARCHAR(1)  NOT NULL,
    MaritalStatus VARCHAR(20)  NOT NULL,
    Race VARCHAR(20)  NOT NULL,
    Religion VARCHAR(30)  NOT NULL,
    Address VARCHAR(50)  NOT NULL,
    Postcode VARCHAR(5)  NOT NULL,
    State VARCHAR(30)  NOT NULL,
    Country VARCHAR(30)  NOT NULL,
    HomeTelNo VARCHAR(14)  NOT NULL,
    MobileNo VARCHAR(14)  NOT NULL,
    PRIMARY KEY (ProfileInfoId)
);

-- Programme table
CREATE TABLE Programme (
    ProgrammeId BIGINT(20),
    ProgrammeName VARCHAR(50)  NOT NULL,
    Overview VARCHAR(255)  NOT NULL,
    LevelOfStudy VARCHAR(30)  NOT NULL,
    Duration INT(2)  NOT NULL,
    Intake VARCHAR(12)  NOT NULL,
    PRIMARY KEY(ProgrammeId)
);

-- Programme table
CREATE TABLE EstimatedFee(
    EstimatedFeeId BIGINT(20),
    TotalFee DECIMAL(10,2) NOT NULL,
    IsLocal BOOLEAN NOT NULL,
    ProgrammeId BIGINT(20) NOT NULL,
    PRIMARY KEY(EstimatedFeeId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId)
);

-- Career table
CREATE TABLE Career (
    CareerId BIGINT(20),
    CareerName VARCHAR(30)  NOT NULL,
    PRIMARY KEY(CareerId)
);

-- Progression table
CREATE TABLE Progression (
    ProgressionId BIGINT(20),
    ProgrammeName VARCHAR(50)  NOT NULL,
    PRIMARY KEY(ProgressionId)
);

-- Campus table
CREATE TABLE Campus (
    CampusId BIGINT(20)  NOT NULL,
    CampusName VARCHAR(40)  NOT NULL,
    PRIMARY KEY(CampusId)
);

-- ProgrammeOutline table
CREATE TABLE ProgrammeOutline (
    ProgrammeOutlineId BIGINT(20)  NOT NULL,
    CourseName VARCHAR(50)  NOT NULL,
    PRIMARY KEY(ProgrammeOutlineId)
);

-- OutlineAssign table
CREATE TABLE OutlineAssign (
    ProgrammeId BIGINT(20)  NOT NULL,
    ProgrammeOutlineId BIGINT(20)  NOT NULL,
    IsElective BOOLEAN  NOT NULL,
    ElectiveNo INT(2) ,
    PRIMARY KEY (ProgrammeId, ProgrammeOutlineId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId),
    FOREIGN KEY (ProgrammeOutlineId) REFERENCES ProgrammeOutline(ProgrammeOutlineId)
);

-- ProgessionAssign table
CREATE TABLE ProgessionAssign (
    ProgrammeId BIGINT(20),
    ProgressionId BIGINT(20),
    Description VARCHAR(150)  NOT NULL,
    PRIMARY KEY (ProgrammeId, ProgressionId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId),
    FOREIGN KEY (ProgressionId) REFERENCES Progression(ProgressionId)
);

-- CareerAssign table
CREATE TABLE CareerAssign (
    ProgrammeId BIGINT(20),
    CareerId BIGINT(20),
    PRIMARY KEY (ProgrammeId, CareerId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId),
    FOREIGN KEY (CareerId) REFERENCES Career(CareerId)
);

-- CampusAssign table
CREATE TABLE CampusAssign (
    ProgrammeId BIGINT(20),
    CampusId BIGINT(20),
    PRIMARY KEY (ProgrammeId, CampusId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId),
    FOREIGN KEY (CampusId) REFERENCES Campus(CampusId)
);

-- EmergencyInfo table
CREATE TABLE EmergencyInfo (
    EmergencyInfoId BIGINT(20),
    FullName VARCHAR(30)  NOT NULL,
    Relationship VARCHAR(15)  NOT NULL,
    Address VARCHAR(50)  NOT NULL,
    Postcode VARCHAR(5)  NOT NULL,
    State VARCHAR(30)  NOT NULL,
    Country VARCHAR(30)  NOT NULL,
    ContactNo VARCHAR(14)  NOT NULL,
    Email VARCHAR(40)  NOT NULL,
    ProfileInfoId BIGINT(20) NOT NULL,
    PRIMARY KEY (EmergencyInfoId),
    FOREIGN KEY (ProfileInfoId) REFERENCES ProfileInfo(ProfileInfoId)
);

-- DetailedInfo table
CREATE TABLE DetailedInfo (
    DetailedInfoId BIGINT(20),
    ICFront BLOB  NOT NULL,
    ICBack BLOB  NOT NULL,
    HouseholdIncome DECIMAL(10, 2) NOT NULL,
    MedicalCondition VARCHAR(80) NOT NULL,
    ProfileInfoId BIGINT(20) NOT NULL,
    PRIMARY KEY(DetailedInfoId),
    FOREIGN KEY (ProfileInfoId) REFERENCES ProfileInfo(ProfileInfoId)
);

-- Qualification table
CREATE TABLE Qualification (
    QualificationId BIGINT(20),
    StartDate DATE  NOT NULL,
    EndDate DATE  NOT NULL,
    ModeOfStudy VARCHAR(20)  NOT NULL,
    InstitutionName VARCHAR(60)  NOT NULL,
    InstitutionLocation VARCHAR(50)  NOT NULL,
    QualificationType VARCHAR(25)  NOT NULL,
    CGPA DECIMAL(5, 4)  NOT NULL,
    LanguageOfInstruction VARCHAR(20)  NOT NULL,
    AcademicCertificate BLOB  NOT NULL,
    AcademicTranscript BLOB  NOT NULL,
    ProfileInfoId BIGINT(20)  NOT NULL,
    PRIMARY KEY (QualificationId),
    FOREIGN KEY (ProfileInfoId) REFERENCES ProfileInfo(ProfileInfoId)
);

-- PreUResult table
CREATE TABLE PreUResult (
    Subject VARCHAR(25),
    QualificationId BIGINT(20),
    Grade VARCHAR(3)  NOT NULL,
    PRIMARY KEY (Subject, QualificationId),
    FOREIGN KEY (QualificationId) REFERENCES Qualification(QualificationId)
);

-- Application table
CREATE TABLE Application(
    ApplicationId BIGINT(20),
    Intake VARCHAR(12) NOT NULL,
    ApplicationStatus VARCHAR(15) NOT NULL,
    StudyMode VARCHAR(20) NOT NULL,
    StartYear INT(4) NOT NULL,
    CampusId BIGINT(20) NOT NULL,
    ProgrammeId BIGINT(20),
    ProfileInfoId BIGINT(20) NOT NULL,
    UserEmail VARCHAR(40) NOT NULL,
    StaffId BIGINT(20) NOT NULL,
    PRIMARY KEY (ApplicationId),
    FOREIGN KEY (CampusId) REFERENCES Campus(CampusId),
    FOREIGN KEY (ProgrammeId) REFERENCES Programme(ProgrammeId),
    FOREIGN KEY (ProfileInfoId) REFERENCES ProfileInfo(ProfileInfoId),
    FOREIGN KEY (UserEmail) REFERENCES Users(UserEmail),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);


-- Enquirer table
CREATE TABLE Enquirer(
    EnquirerEmail VARCHAR(30),
    Contact VARCHAR(14)  NOT NULL,
    Name VARCHAR(30)  NOT NULL,
    Nationality VARCHAR(30)  NOT NULL,
    PRIMARY KEY (EnquirerEmail)
);

-- Enquiry table
CREATE TABLE Enquiry(
    EnquiryId BIGINT(20),
    HighestLvlEduc VARCHAR(30) NOT NULL,
    ProgrammeLvlInterest VARCHAR(40)  NOT NULL,
    ProgrammeInterest VARCHAR(40)  NOT NULL,
    Question VARCHAR(200)  NOT NULL,
    Reply TEXT(2000)  NOT NULL,
    EnquiryStatus VARCHAR(25)  NOT NULL,
    EnquirerEmail VARCHAR(30) NOT NULL,
    StaffId BIGINT(20) ,    
    PRIMARY KEY (EnquiryId),
    FOREIGN KEY (EnquirerEmail) REFERENCES Enquirer(EnquirerEmail),
    FOREIGN KEY (StaffId) REFERENCES Staff(StaffId)
);


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--- Insert Records
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- Users table
-- (UserEmail, Password, RegisteredDate)
INSERT INTO Users VALUES ('johndoe@gmail.com', 'password123', '2023-03-08');
INSERT INTO Users VALUES ('janedoe@gmail.com', 'password456', '2023-03-09');

-- Staff table
-- (StaffId, Username, Password, StaffName, StaffContact, StaffEmail, StaffPosition, StaffRole, ResearchArea)
INSERT INTO Staff VALUES (1, 'admin', 'password123', 'John Doe', '0123456789', 'johndoe@gmail.com', 'Dean', 'Administration', 'Computer Science');
INSERT INTO Staff VALUES (2, 'staff', 'password456', 'Jane Doe', '0123456780', 'janedoe@gmail.com', 'Lecturer', 'Teaching', 'Mathematics');

-- ProfileInfo table
INSERT INTO ProfileInfo VALUES (1, 'John Doe', '123456789012', 'Malaysian', '1990-01-01', 'M', 'Single', 'Chinese', 'Buddhism', '123 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0312345678', '0123456789');
INSERT INTO ProfileInfo VALUES (2, 'Jane Doe', '987654321009', 'Malaysian', '1991-02-02', 'F', 'Married', 'Malay', 'Islam', '456 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0312345670', '0123456780');

-- Programme table
-- (ProgrammeId, ProgrammeName, Overview, LevelOfStudy, Duration, Intake)
INSERT INTO Programme VALUES (1, 'Bachelor of Computer Science', 'A 3-year programme that prepares students for a career in computer science.', 'Undergraduate', 3, '2023/2024');
INSERT INTO Programme VALUES (2, 'Master of Business Administration', 'A 2-year programme that prepares students for a career in business administration.', 'Postgraduate', 2, '2023/2024');

-- EstimatedFee table
-- (EstimatedFeeId, TotalFee, IsLocal, ProgrammeId)
INSERT INTO EstimatedFee VALUES (1, 10000, 1, 1);
INSERT INTO EstimatedFee VALUES (2, 20000, 0, 2);

-- Career table
-- (CareerId, CareerName)
INSERT INTO Career VALUES (1, 'Software Engineer');
INSERT INTO Career VALUES (2, 'Data Scientist');

-- Progression table
-- (ProgressionId, ProgrammeName)
INSERT INTO Progression VALUES (1, 'Bachelor of Computer Science (Honours)');
INSERT INTO Progression VALUES (2, 'Master of Business Administration (MBA)');

-- Campus table
-- (CampusId, CampusName)
INSERT INTO Campus VALUES (1, 'Kuala Lumpur Campus');
INSERT INTO Campus VALUES (2, 'Penang Campus');

-- ProgrammeOutline table
-- (ProgrammeOutlineId, CourseName)
INSERT INTO ProgrammeOutline VALUES (1, 'Introduction to Computer Science');
INSERT INTO ProgrammeOutline VALUES (2, 'Data Structures and Algorithms');

-- OutlineAssign table
-- (ProgrammeId, ProgrammeOutlineId, IsElective, ElectiveNo)
INSERT INTO OutlineAssign VALUES (1, 1, 0, 1);
INSERT INTO OutlineAssign VALUES (1, 2, 1, 2);

-- ProgessionAssign table
--(ProgrammeId, ProgressionId, Description)
INSERT INTO ProgessionAssign VALUES (1, 1, 'A 1-year programme that allows students to specialize in a particular area of computer science.');
INSERT INTO ProgessionAssign VALUES (2, 2, 'A 1-year programme that allows students to specialize in a particular area of business administration.');

-- CareerAssign table
-- (ProgrammeId, CareerId)
INSERT INTO CareerAssign VALUES (1, 1);
INSERT INTO CareerAssign VALUES (2, 2);

-- CampusAssign table
-- (ProgrammeId, CampusId)
INSERT INTO CampusAssign (ProgrammeId, CampusId)VALUES (1, 1);
INSERT INTO CampusAssign (ProgrammeId, CampusId)VALUES (1, 2);
INSERT INTO CampusAssign (ProgrammeId, CampusId)VALUES (2, 1);

-- EmergencyInfo table
-- (EmergencyInfoId, FullName, Relationship, Address, Postcode, State, Country, ContactNo, Email, ProfileInfoId)
INSERT INTO EmergencyInfo VALUES (1, 'John Smith', 'Father', '123 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0123456789', 'john.smith@gmail.com', 1);
INSERT INTO EmergencyInfo VALUES (2, 'Jane Doe', 'Mother', '456 Main Street', '50000', 'Kuala Lumpur', 'Malaysia', '0123456780', 'jane.doe@gmail.com', 2);

-- DetailedInfo table
-- (DetailedInfoId, ICFront, ICBack, HouseholdIncome, MedicalCondition, ProfileInfoId)
INSERT INTO DetailedInfo VALUES (1, '123456789012.jpg', '987654321009.jpg', 50000, 'None', 1);
INSERT INTO DetailedInfo VALUES (2, '456789012345.jpg', '678901234567.jpg', 80000, 'Asthma', 2);

-- Qualification table
-- (QualificationId, StartDate, EndDate, ModeOfStudy, InstitutionName, InstitutionLocation, QualificationType, CGPA, LanguageOfInstruction, AcademicCertificate, AcademicTranscript, ProfileInfoId)
INSERT INTO Qualification VALUES (1, '2019-01-01', '2022-12-31', 'Full-time', 'University of Malaya', 'Kuala Lumpur', 'Degree', 3.8, 'English', 'certificate.pdf', 'transcript.pdf', 1);
INSERT INTO Qualification VALUES (2, '2017-01-01', '2019-12-31', 'Part-time', 'Tunku Abdul Rahman University College', 'Penang', 'Diploma', 3.5, 'Malay', 'certificate.pdf', 'transcript.pdf', 2);

-- PreUResult table
-- (Subject, QualificationId, Grade)
INSERT INTO PreUResult VALUES ('Mathematics', 1, 'A');
INSERT INTO PreUResult VALUES ('Physics', 1, 'B');
INSERT INTO PreUResult VALUES ('Chemistry', 1, 'A');

-- Application table
-- (ApplicationId, Intake, ApplicationStatus, StudyMode, StartYear, CampusId, ProgrammeId, ProfileInfoId, UserEmail, StaffId)
INSERT INTO Application VALUES (1, '2023/2024', 'Pending', 'Full-time', '2023', 1, 1, 1, 'johndoe@gmail.com', 2);
INSERT INTO Application VALUES (2, '2023/2024', 'Pending', 'Part-time', '2023', 2, 2, 2, 'janedoe@gmail.com', NULL);


-- Enquirer table
-- (EnquirerEmail, Contact, Name, Nationality)
INSERT INTO Enquirer VALUES ('enquiry@gmail.com', '0123456789', 'John Doe', 'Malaysian');

-- Enquiry table
-- (EnquiryId, HighestLvlEduc, ProgrammeLvlInterest, ProgrammeInterest, Question, Reply, EnquiryStatus, EnquirerEmail, StaffId)
INSERT INTO Enquiry VALUES (1, 'STPM', 'Undergraduate', 'Bachelor of Computer Science', 'What are the admission requirements for the Bachelor of Computer Science programme?', 'The admission requirements for the Bachelor of Computer Science programme are:

* SPM with a minimum of 5 credits in Mathematics, Physics, and Chemistry.
* A Diploma in Computer Science or a related field.
* An equivalent qualification recognized by the University.

The application deadline is 31 March 2023.', 'Pending', 'enquiry@gmail.com', 1);
