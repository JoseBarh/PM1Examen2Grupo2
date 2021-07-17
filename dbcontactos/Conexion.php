<?php

    $hostname = 'localhost';
    $database = 'dbcontactos';
    $username = 'root';
    $password = '';

    $conexion = new mysqli($hostname, $database, $username, $password);
    if($conexion -> connect_error){
        echo "Lo sentimos, el sitio web esta experimentando problemas!!";
    }

?>