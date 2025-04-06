<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des Produits</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<h1>Liste des Produits</h1>

<c:if test="${not empty message}">
    <div style="color: green; margin-bottom: 15px;">
            ${message}
    </div>
</c:if>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Description</th>
        <th>Prix</th>
        <th>Image</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty produits}">
            <tr>
                <td colspan="6" style="text-align: center;">Aucun produit disponible</td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="produit" items="${produits}">
                <tr>
                    <td>${produit.id}</td>
                    <td>${produit.nom}</td>
                    <td>${produit.description}</td>
                    <td>${produit.prix} ?</td>
                    <td>
                        <c:if test="${not empty produit.image}">
                            <img src="${pageContext.request.contextPath}/images/${produit.image}"
                                 alt="${produit.nom}" width="50" height="50">
                        </c:if>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/ProduitController?action=modifier&id=${produit.id}">Modifier</a>
                        <a href="${pageContext.request.contextPath}/ProduitController?action=supprimer&id=${produit.id}"
                           onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?');">
                            Supprimer
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

<div style="margin-top: 20px;">
    <a href="${pageContext.request.contextPath}/ajouterProduit.jsp">Ajouter un nouveau produit</a>
</div>
<!-- Retour à l'accueil -->
<a href="home.jsp">Retour à l'accueil</a>
</body>
</html>
