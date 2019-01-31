INSERT INTO TipoMejora (id, modificationCounter, descripcion) VALUES (0, 1, 'Marco');
INSERT INTO TipoMejora (id, modificationCounter, descripcion) VALUES (1, 1, 'Fondo');

INSERT INTO Persona (id, modificationCounter, nombre, fechaNacimiento, email) VALUES (0, 1, 'Marco Antonio', CURRENT_TIMESTAMP, 'marcoantonio@gmail.com');

INSERT INTO Usuario (id, modificationCounter, username, password, idPersona) VALUES (0, 1, 'manton', 'flotus1', 0);

INSERT INTO Apuesta (id, modificationCounter, ladoApostado, resultado, fecha, valorApostado, valorGanado, idUsuario) VALUES (0, 1, 'true', 'true', CURRENT_TIMESTAMP, 12345.67, 10.5, 0);