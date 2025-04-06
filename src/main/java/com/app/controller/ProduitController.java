package com.app.controller;

import com.app.dao.*;
import com.app.metier.GestionArticle;
import com.app.metier.Produit;
import javax.servlet.annotation.WebServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet("/ProduitController")
public class ProduitController extends HttpServlet {
    private GestionArticle gestionArticle;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialiser le DAO et la gestion des articles
        IGestionArticleDAO articleDAO = new GestionArticleDAO(DBConnection.getConnection());
        gestionArticle = new GestionArticle(articleDAO);
    }

    // doGet pour afficher la liste des produits ou les détails d'un produit
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("details".equals(action)) {
            // Afficher les détails d'un produit spécifique
            int id = Integer.parseInt(request.getParameter("id"));
            Produit produit = gestionArticle.getProduitById(id);

            if (produit != null) {
                request.setAttribute("produit", produit);
                request.getRequestDispatcher("/detailsProduit.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Produit non trouvé");
            }
        } else {
            // Afficher la liste des produits
            List<Produit> produits = gestionArticle.listerProduits();
            request.setAttribute("produits", produits);
            request.getRequestDispatcher("/listeProduits.jsp").forward(request, response);
        }
    }

    // doPost pour gérer l'ajout et la modification des produits
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("ajouter".equals(action)) {
                // Ajouter un produit
                String nom = request.getParameter("nom");
                String description = request.getParameter("description");
                String prixString = request.getParameter("prix");
                String image = request.getParameter("image");

                // Validation des champs
                if (nom == null || nom.trim().isEmpty() || description == null || description.trim().isEmpty() || prixString == null || prixString.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Tous les champs sont obligatoires !");
                    request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
                    return;
                }

                // Conversion du prix
                double prix = 0;
                try {
                    prix = Double.parseDouble(prixString.trim());
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Le prix doit être un nombre valide !");
                    request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
                    return;
                }

                Produit produit = new Produit(nom, description, prix, image);
                gestionArticle.ajoutProduit(produit);

                // Redirection vers la liste des produits
                response.sendRedirect("ProduitController?action=liste");

            } else if ("modifier".equals(action)) {
                // Modifier un produit
                int id = Integer.parseInt(request.getParameter("id"));
                String nom = request.getParameter("nom");
                String description = request.getParameter("description");
                String prixString = request.getParameter("prix");
                String image = request.getParameter("image");

                // Validation des champs
                if (nom == null || nom.trim().isEmpty() || description == null || description.trim().isEmpty() || prixString == null || prixString.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Tous les champs sont obligatoires !");
                    request.getRequestDispatcher("/modifierProduit.jsp?id=" + id).forward(request, response);
                    return;
                }

                // Conversion du prix
                double prix = 0;
                try {
                    prix = Double.parseDouble(prixString.trim());
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMessage", "Le prix doit être un nombre valide !");
                    request.getRequestDispatcher("/modifierProduit.jsp?id=" + id).forward(request, response);
                    return;
                }

                Produit produit = new Produit(id, nom, description, prix, image);
                gestionArticle.modifierProduit(produit);

                // Redirection vers les détails du produit
                response.sendRedirect("ProduitController?action=details&id=" + id);
            }

        } catch (Exception e) {
            // Gestion des erreurs globales
            e.printStackTrace(); // Log the error
            request.setAttribute("errorMessage", "Une erreur est survenue, veuillez réessayer.");
            request.getRequestDispatcher("/erreur.jsp").forward(request, response);
        }
    }


    @Override
    public void destroy() {
        // Libérer les ressources
        gestionArticle = null;
    }
}
