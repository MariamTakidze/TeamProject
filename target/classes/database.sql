use big_task;
INSERT INTO city VALUES(1,'Batumi');
INSERT INTO city VALUES(2,'Qutaisi');
INSERT INTO city VALUES(3,'Tbilisi');

describe stations;

INSERT INTO stations VALUES(1,'sadguri',1);
INSERT INTO stations VALUES(2,'plaza',1);
INSERT INTO stations VALUES(3,'maki',2);
INSERT INTO stations VALUES(4,'meria',2);
INSERT INTO stations VALUES(5,'didube',3);
INSERT INTO stations VALUES(6,'ortachala',3);
INSERT INTO stations VALUES(7,'station_square',3);
UPDATE stations set name='bikentia' WHERE id_stations=4;

select * from stations;

select * from distances;

INSERT INTO distances VALUES(1,1,0);
INSERT INTO distances VALUES(1,2,5);
INSERT INTO distances VALUES(1,3,999999);
INSERT INTO distances VALUES(1,4,999999);
INSERT INTO distances VALUES(1,5,999999);
INSERT INTO distances VALUES(1,6,999999);
INSERT INTO distances VALUES(1,7,999999);


INSERT INTO distances VALUES(2,1,5);
INSERT INTO distances VALUES(2,2,0);
INSERT INTO distances VALUES(2,3,235);
INSERT INTO distances VALUES(2,4,999999);
INSERT INTO distances VALUES(2,5,999999);
INSERT INTO distances VALUES(2,6,999999);
INSERT INTO distances VALUES(2,7,999999);

INSERT INTO distances VALUES(3,1,999999);
INSERT INTO distances VALUES(3,2,235);
INSERT INTO distances VALUES(3,3,0);
INSERT INTO distances VALUES(3,4,12);
INSERT INTO distances VALUES(3,5,217);
INSERT INTO distances VALUES(3,6,999999);
INSERT INTO distances VALUES(3,7,999999);


INSERT INTO distances VALUES(4,1,999999);
INSERT INTO distances VALUES(4,2,999999);
INSERT INTO distances VALUES(4,3,12);
INSERT INTO distances VALUES(4,4,0);
INSERT INTO distances VALUES(4,5,999999);
INSERT INTO distances VALUES(4,6,999999);
INSERT INTO distances VALUES(4,7,999999);

INSERT INTO distances VALUES(5,1,999999);
INSERT INTO distances VALUES(5,2,999999);
INSERT INTO distances VALUES(5,3,217);
INSERT INTO distances VALUES(5,4,999999);
INSERT INTO distances VALUES(5,5,0);
INSERT INTO distances VALUES(5,6,25);
INSERT INTO distances VALUES(5,7,11);

INSERT INTO distances VALUES(6,1,999999);
INSERT INTO distances VALUES(6,2,999999);
INSERT INTO distances VALUES(6,3,999999);
INSERT INTO distances VALUES(6,4,999999);
INSERT INTO distances VALUES(6,5,25);
INSERT INTO distances VALUES(6,6,0);
INSERT INTO distances VALUES(6,7,18);

INSERT INTO distances VALUES(7,1,999999);
INSERT INTO distances VALUES(7,2,999999);
INSERT INTO distances VALUES(7,3,999999);
INSERT INTO distances VALUES(7,4,999999);
INSERT INTO distances VALUES(7,5,11);
INSERT INTO distances VALUES(7,6,18);
INSERT INTO distances VALUES(7,7,0);


select * from distances;

select * from transport;

INSERT INTO transport VALUES(1,'car',80);
INSERT INTO transport VALUES(2,'bus',60);
INSERT INTO transport VALUES(3,'minibus',70);


