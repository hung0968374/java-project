-- Patients
INSERT INTO patient (name, email, created_at, updated_at) VALUES ('John Doe', 'john.doe@example.com', NOW(), NOW());
INSERT INTO patient (name, email, created_at, updated_at) VALUES ('Jane Smith', 'jane.smith@example.com', NOW(), NOW());

-- Doctors
INSERT INTO doctor (name, specialization, created_at, updated_at) VALUES ('Dr. Alice Brown', 'Cardiology', NOW(), NOW());
INSERT INTO doctor (name, specialization, created_at, updated_at) VALUES ('Dr. Bob White', 'Neurology', NOW(), NOW());

-- Staff
INSERT INTO staff (name, role, created_at, updated_at) VALUES ('Charlie Green', 'Receptionist', NOW(), NOW());
INSERT INTO staff (name, role, created_at, updated_at) VALUES ('David Black', 'Manager', NOW(), NOW());

-- Appointments
INSERT INTO appointment (patient_id, doctor_id, appointment_time, created_at, updated_at) VALUES (1, 1, '2024-08-06 10:00:00', NOW(), NOW());
INSERT INTO appointment (patient_id, doctor_id, appointment_time, created_at, updated_at) VALUES (2, 2, '2024-08-07 11:00:00', NOW(), NOW());

-- Prescriptions
INSERT INTO prescription (doctor_id, patient_id, details, created_at, updated_at) VALUES (1, 1, 'Take 1 tablet daily', NOW(), NOW());
INSERT INTO prescription (doctor_id, patient_id, details, created_at, updated_at) VALUES (2, 2, 'Rest and hydration', NOW(), NOW());