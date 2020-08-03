--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements
insert into lead (id, country_ISO_code, email, name, phone_number) values (1, 'BR', 'fmartinie0@ucoz.ru', 'Frederik Martinie', '785-454-0140')
insert into lead (id, country_ISO_code, email, name, phone_number) values (2, 'CN', 'cwessel1@ihg.com', 'Constantino Wessel', '503-314-5985')
insert into lead (id, country_ISO_code, email, name, phone_number) values (3, 'PL', 'adinneen2@pen.io', 'April Dinneen', '577-148-5405')
insert into lead (id, country_ISO_code, email, name, phone_number) values (4, 'ID', 'bmaccafferky3@techcrunch.com', 'Byrle MacCafferky', '889-282-5877')
insert into lead (id, country_ISO_code, email, name, phone_number) values (5, 'PH', 'tstannislawski4@engadget.com', 'Twila Stannislawski', '979-514-4011')
insert into lead (id, country_ISO_code, email, name, phone_number) values (6, 'HT', 'kcayzer5@rakuten.co.jp', 'Kevyn Cayzer', '893-873-0337')
insert into lead (id, country_ISO_code, email, name, phone_number) values (7, 'PT', 'tblaiklock6@mayoclinic.com', 'Tressa Blaiklock', '666-545-8137')
insert into lead (id, country_ISO_code, email, name, phone_number) values (8, 'US', 'idownie7@discovery.com', 'Iormina Downie', '217-798-3006')
insert into lead (id, country_ISO_code, email, name, phone_number) values (9, 'RU', 'tspilsted8@ycombinator.com', 'Trula Spilsted', '808-735-5535')
insert into lead (id, country_ISO_code, email, name, phone_number) values (10, 'RU', 'wadey9@cmu.edu', 'Wald Adey', '325-556-2876')
insert into lead_vehicle_req (id, requirement, leadId) values (1, 'Mazda', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (2, 'Ford', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (3, 'Volvo', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (4, 'Scion', 10)
insert into lead_vehicle_req (id, requirement, leadId) values (5, 'Subaru', 4)
insert into lead_vehicle_req (id, requirement, leadId) values (6, 'Toyota', 2)
insert into lead_vehicle_req (id, requirement, leadId) values (7, 'Audi', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (8, 'Toyota', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (9, 'Mercedes-Benz', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (10, 'GMC', 4)
insert into lead_vehicle_req (id, requirement, leadId) values (11, 'Plymouth', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (12, 'BMW', 1)
insert into lead_vehicle_req (id, requirement, leadId) values (13, 'Ford', 10)
insert into lead_vehicle_req (id, requirement, leadId) values (14, 'Chrysler', 2)
insert into lead_vehicle_req (id, requirement, leadId) values (15, 'Pontiac', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (16, 'Volkswagen', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (17, 'Infiniti', 4)
insert into lead_vehicle_req (id, requirement, leadId) values (18, 'Toyota', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (19, 'Toyota', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (20, 'Cadillac', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (21, 'Acura', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (22, 'Land Rover', 4)
insert into lead_vehicle_req (id, requirement, leadId) values (23, 'Ford', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (24, 'Volvo', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (25, 'Toyota', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (26, 'GMC', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (27, 'Dodge', 10)
insert into lead_vehicle_req (id, requirement, leadId) values (28, 'GMC', 2)
insert into lead_vehicle_req (id, requirement, leadId) values (29, 'BMW', 6)
insert into lead_vehicle_req (id, requirement, leadId) values (30, 'Subaru', 2)
insert into lead_vehicle_req (id, requirement, leadId) values (31, 'Mazda', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (32, 'BMW', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (33, 'Buick', 1)
insert into lead_vehicle_req (id, requirement, leadId) values (34, 'Suzuki', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (35, 'Chevrolet', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (36, 'Saturn', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (37, 'Dodge', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (38, 'Volvo', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (39, 'Ram', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (40, 'Infiniti', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (41, 'Chevrolet', 8)
insert into lead_vehicle_req (id, requirement, leadId) values (42, 'Dodge', 3)
insert into lead_vehicle_req (id, requirement, leadId) values (43, 'Ford', 9)
insert into lead_vehicle_req (id, requirement, leadId) values (44, 'Chevrolet', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (45, 'Ford', 1)
insert into lead_vehicle_req (id, requirement, leadId) values (46, 'Porsche', 4)
insert into lead_vehicle_req (id, requirement, leadId) values (47, 'Subaru', 5)
insert into lead_vehicle_req (id, requirement, leadId) values (48, 'Chevrolet', 7)
insert into lead_vehicle_req (id, requirement, leadId) values (49, 'Infiniti', 6)
insert into lead_vehicle_req (id, requirement, leadId) values (50, 'Hillman', 6)

