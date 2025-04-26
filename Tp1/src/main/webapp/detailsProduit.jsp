<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Détails du Produit</title>
    <style>
        .product-details {
            margin: 20px;
            padding: 20px;
            border: 1px solid #ddd;
            width: 60%;
            margin-left: auto;
            margin-right: auto;
        }
        .product-details h2 {
            text-align: center;
        }
        .product-details div {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Détails du Produit</h1>

<c:if test="${not empty produit}">
    <div class="product-details">
        <h2>${produit.nom}</h2>
        <div><strong>Description:</strong> ${produit.description}</div>
        <div><strong>Prix:</strong> ${produit.prix} ?</div>
        <div><strong>Image:</strong></div>
        <c:if test="${not empty produit.image}">
            <img src="${pageContext.request.contextPath}/images/${produit.image}" alt="${produit.nom}" width="200" height="200">
        </c:if>
        <br>
        <a href="${pageContext.request.contextPath}/ProduitController?action=modifier&id=${produit.id}">Modifier</a>
        <a href="${pageContext.request.contextPath}/ProduitController?action=supprimer&id=${produit.id}"
           onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?');">Supprimer</a>
    </div>
</c:if>

</body>
</html>

