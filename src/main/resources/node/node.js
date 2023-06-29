const express = require('express');
const fs = require('fs');
const { v4: uuidv4 } = require('uuid');
const formidable = require('formidable');
const mysql = require('mysql2');
const path = require('path');

const app = express();

// Configuración de la conexión a la base de datos MySQL
const dbConfig = {
    host: 'localhost',
    user: 'root',
    password: '123456',
    database: 'mydb',
};

// Crea una conexión a la base de datos MySQL
const connection = mysql.createConnection(dbConfig);

// Establece la conexión a la base de datos
connection.connect((err) => {
    if (err) {
        console.error('Error al conectar a la base de datos:', err);
    } else {
        console.log('Conexión exitosa a la base de datos MySQL');
    }
});

// Ruta para mostrar el formulario de carga de imágenes
app.get('/', (req, res) => {
    const indexPath = path.join(__dirname, '..', 'templates', 'index.html');
    fs.readFile(indexPath, (err, data) => {
        if (err) {
            res.status(404).send('Archivo no encontrado');
        } else {
            res.setHeader('Content-Type', 'text/html'); // Establecer el Content-Type a "text/html"
            res.status(200).send(data);
        }
    });
});

// Ruta para manejar la carga de imágenes
app.post('/upload', (req, res) => {
    const form = new formidable.IncomingForm();

    form.parse(req, (err, fields, files) => {
        if (err) {
            res.status(500).send('Error al cargar la imagen');
            return;
        }

        const file = files.upload;
        if (!file) {
            res.status(400).send('No se seleccionó ningún archivo');
            return;
        }

        const fileExtension = path.extname(file.name || '').toLowerCase();
        const fileName = uuidv4() + fileExtension;
        const oldPath = file.path || file.filepath;
        const newPath = path.join(__dirname, 'uploads', fileName);

        fs.rename(oldPath, newPath, (err) => {
            if (err) {
                res.status(500).send('Error al guardar la imagen');
            } else {
                // Guardar la información de la imagen en la base de datos
                const imageUrl = '/uploads/' + fileName;
                const sql = 'INSERT INTO images (url) VALUES (?)';
                connection.query(sql, [imageUrl], (err, result) => {
                    if (err) {
                        res.status(500).send('Error al guardar la imagen en la base de datos');
                    } else {
                        res.redirect('/'); // Redirigir al formulario después de la carga exitosa
                    }
                });
            }
        });
    });
});

// Ruta para mostrar las imágenes cargadas
app.use('/uploads', express.static(path.join(__dirname, 'uploads')));

// Iniciar el servidor
const port = 3000;
app.listen(port, () => {
    console.log(`Servidor Node.js en ejecución en http://localhost:${port}`);
});