<?php
$conn = mysqli_connect("localhost", "root", "", "android");
//store json
$respone = array();

if (isset($_POST['username'])) {

    $username = $_POST['username'];
    $password = $_POST['password'];

    $sql = "INSERT INTO user VALUES (null , '$username' , '$password')";

    $result = mysqli_query($conn, $sql);

    if (mysqli_affected_rows($conn) > 0) {
        $respone['success'] = "1";
    } else {
        $respone['success'] = "0";
    }
}
echo json_encode($respone);
?>
