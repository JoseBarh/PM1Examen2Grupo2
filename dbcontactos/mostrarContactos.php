<?php
    include './Conexion.php';

    $id = $_POST ['id'];
    $img = $_POST ['img'];
    $nombre = $_POST ['nombre'];
    $telefono = $_POST ['telefono'];
    $latitud = $_POST ['latitud'];
    $longitud = $_POST ['longitud'];

    $consulta = "SELECT * INTO contactos VALUES('"$id"', '"$img"', '"$nombre"', '"$telefono"', '"$latitud"', '"$longitud"')";
    mysqli_query($conexion,$consulta) or die (mysqli_error());
    mysqli_close();
?>