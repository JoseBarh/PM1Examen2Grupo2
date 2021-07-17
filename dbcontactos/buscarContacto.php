<?php
    include './Conexion.php';
    $id = $_GET ['id'];

    $consulta = "SELECT * FROM contactos WHERE id = '$id'";
    $resultado = $conexion -> query($consulta);

    while($fila=$resultado -> fetch_array()){
        $contacto[] = array_map('utf8_encode', $fila);
    }

    echo json_encode($contacto);
    $resultado -> close();
?>