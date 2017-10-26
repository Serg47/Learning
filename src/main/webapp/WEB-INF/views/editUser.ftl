<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User Page</title>
</head>
<body>
<form name="user" action="/updateUser" method="post">
    <h5>Id</h5>
    <input title="Id" type="text" name="name" value="${user.id}">
    <br>
    <h5>Name</h5>
    <input title="Name" type="text" name="name" value="${user.name}">
    <br>
    <h5>Email</h5>
    <input title="Email" type="text" name="email" value="${user.email}">
    <br>
    <h5>Namber</h5>
    <input title="Number" type="text" name="number" value="${user.number}">
    <input type="submit" value="ok">

</form>
</body>
</html>