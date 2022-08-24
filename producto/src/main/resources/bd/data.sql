INSERT INTO ubicacion (ubicacion_id, ubicacion_nombre) VALUES (1,'Trujillo') ON CONFLICT (ubicacion_id) DO NOTHING;
INSERT INTO ubicacion (ubicacion_id, ubicacion_nombre) VALUES (2,'Arequipa') ON CONFLICT (ubicacion_id) DO NOTHING;
INSERT INTO ubicacion (ubicacion_id, ubicacion_nombre) VALUES (3,'Lima') ON CONFLICT (ubicacion_id) DO NOTHING;