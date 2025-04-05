<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter un Produit</title>
    <style>
        form {
            width: 50%;
            margin-left: auto;
            margin-right: auto;
            padding: 20px;
            border: 1px solid #ddd;
        }
        input[type="text"], input[type="number"], input[type="file"] {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Ajouter un Nouveau Produit</h1>

<form action="${pageContext.request.contextPath}/ProduitController?action=ajouter" method="POST" enctype="multipart/form-data">
    <div>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required>
    </div>
    <div>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required>
    </div>
    <div>
        <label for="prix">Prix:</label>
        <input type="number" id="prix" name="prix" required step="0.01">
    </div>
    <div>
        <label for="image">Image (optionnel):</label>
        <input type="file" id="image" name="image">
    </div>
    <div>
        <input type="submit" value="Ajouter le produit">
    </div>
</form>

</body>
</html>

