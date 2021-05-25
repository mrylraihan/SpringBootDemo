DROP SCHEMA IF EXISTS pickameeting_db;

CREATE SCHEMA pickameeting_db;
use pickameeting_db;

CREATE TABLE  meeting (
	meeting_id INT AUTO_INCREMENT,
	scheduler_name VARCHAR(50),
	team_name VARCHAR(50),
	purpose VARCHAR(100),
	meeting_date DATE,
	CONSTRAINT ps_customer_id_pk PRIMARY KEY (meeting_id)
);

INSERT INTO meeting (meeting_id, scheduler_name, team_name, purpose, meeting_date) values (1, 'Scott Adams', 'ETAMYSJAVA', 'Discuss the new tool', SYSDATE()+INTERVAL 2 DAY);
INSERT INTO meeting (meeting_id, scheduler_name, team_name, purpose, meeting_date) values (2, 'James Williams', 'ETAMYSMS', 'Team Meeting', SYSDATE()+INTERVAL 1 DAY);
INSERT INTO meeting (meeting_id, scheduler_name, team_name, purpose, meeting_date) values (3, 'Mary Lue', 'ETAMYSBI', 'Birthday Celebrations', SYSDATE());
INSERT INTO meeting (meeting_id, scheduler_name, team_name, purpose, meeting_date) values (4, 'Eva Longe', 'ETAMYSUI', 'Awards Ceremony', SYSDATE()-INTERVAL 1 DAY);
INSERT INTO meeting (meeting_id, scheduler_name, team_name, purpose, meeting_date) values (5, 'Matthew Bane', 'ETAMYSAI', 'Discuss appraisals scedule', SYSDATE()-INTERVAL 2 DAY);