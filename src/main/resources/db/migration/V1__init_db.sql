CREATE TABLE worker1 (
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000),
                         BIRTHDAY YEAR CHECK (BIRTHDAY > 1900),
                         LEVEL ENUM('Trainee', 'Junior', 'Middle', 'Senior'),
                         SALARY INT CHECK (SALARY >= 100 AND SALARY <= 100000)
);

CREATE TABLE client1 (
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);

CREATE TABLE project1 (
                          ID INT AUTO_INCREMENT PRIMARY KEY,
                          CLIENT_ID INT,
                          START_DATE DATE,
                          FINISH_DATE DATE
);

CREATE TABLE project_worker1 (
                                 PROJECT_ID INT,
                                 WORKER_ID INT,
                                 PRIMARY KEY (PROJECT_ID, WORKER_ID),
                                 FOREIGN KEY (PROJECT_ID) REFERENCES project1(ID),
                                 FOREIGN KEY (WORKER_ID) REFERENCES worker1(ID)
);

ALTER TABLE project1
    ADD CONSTRAINT CLIENT_ID_FK1 FOREIGN KEY (CLIENT_ID) REFERENCES client1(ID);
