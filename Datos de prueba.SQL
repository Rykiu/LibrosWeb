INSERT INTO Editorial (nombre, alta)
VALUES
('Puton Ediciones', 1),
('Debolsillo', 1),
('Sudamericana', 1),
('Alfaguarda', 1),
('Booknet', 1),
('Planetalector', 1),
('Del Fondo Editorial', 1),
('Santillana', 1);

INSERT INTO Autor (nombre, alta)
VALUES
('Miguel de Cervantes', 1),
('Gabriel García Márquez', 1),
('Isabel Allende', 1),
('Julio Cortázar', 1),
('Pablo Neruda', 1),
('Ernesto Sábato', 1),
('José Hernández', 1),
('Jorge Luis Borges', 1),
('Griselda Gambaro', 1);

INSERT INTO Libro (isbn, titulo, anio, ejemplares, ejemplaresprestados, ejemplaresrestantes, alta, editorial_id, autor_id)
VALUES
(9788493806125, 'El ingenioso hidalgo Don Quijote de la Mancha', 1605, 90, 25, 65, 1, 1, 1),
(9789871138142, 'Cien años de soledad', 1967, 50, 5, 45, 1, 2, 2),
(9789500767767, 'La casa de los espiritus', 1982, 75, 15, 60, 1, 3, 3),
(9789878266770, 'Rayuela', 1963, 60, 20, 40, 1, 4, 4),
(9789878220772, 'Veinte poemas de amor', 1924, 120, 30, 90, 1, 5, 5),
(9789877670264, 'El túnel', 1948, 80, 10, 70, 1, 6, 6),
(9789878304724, 'Martín Fierro', 1872, 110, 15, 95, 1, 7, 7),
(9789875666474, 'Ficciones', 1944, 70, 5, 65, 1, 2, 8),
(9789504662105, 'El mar que nos trajo', 2001, 100, 10, 90, 1, 8, 9),
(9789500726085, 'El amor en tiempos del cólera', 1996, 65, 20, 45, 1, 3, 2);