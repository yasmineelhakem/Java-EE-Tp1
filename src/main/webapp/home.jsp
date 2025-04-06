<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
<h1>Welcome, ${sessionScope.user}!</h1>
    <a href="ProduitController?action=liste">Voir la Liste des Produits</a> <br>
    <a href="ajouterProduit.jsp">Ajouter un Nouveau Produit</a> <br>
    <a href="logout">Logout</a>
</body>
</html>

