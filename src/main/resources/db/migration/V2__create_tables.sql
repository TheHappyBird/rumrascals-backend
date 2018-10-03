CREATE sequence hibernate_sequence
  start 10
  increment 1;

CREATE TABLE COMPANY (
  ID            INT AUTO_INCREMENT,
  NAME          VARCHAR(255) NOT NULL,
  DESCRIPTION   VARCHAR(2000),
  FOUNDED_YEAR  INT,
  COUNTRY       VARCHAR(255),
  primary key (ID)
);

CREATE TABLE RUM (
  ID            INT AUTO_INCREMENT,
  NAME          VARCHAR(255) NOT NULL,
  DESCRIPTION   VARCHAR(2000),
  YEAR          INT,
  COMPANY_ID    INT,
  primary key (ID),
  constraint RUM_FK_COMPANY_ID foreign key (COMPANY_ID) references COMPANY (ID) on delete set null
);

INSERT into COMPANY (NAME, DESCRIPTION, FOUNDED_YEAR, COUNTRY) VALUES ('Cool company', 'Super cool company that makes rum', 1987, 'Swe');
INSERT into COMPANY (NAME, DESCRIPTION, FOUNDED_YEAR, COUNTRY) VALUES ('Cool company2', 'Super cool company that makes rum', 1987, 'Swe');
INSERT into COMPANY (NAME, DESCRIPTION, FOUNDED_YEAR, COUNTRY) VALUES ('Cool company3', 'Super cool company that makes rum', 1987, 'Swe');

INSERT  into RUM (NAME, DESCRIPTION, "YEAR", COMPANY_ID) VALUES ('Cool rum', 'The best rum', 1990, 2);
