package com.app.metier;

import com.app.dao.IGestionArticleDAO;
import com.app.dao.IGestionArticleDAO;

import com.app.metier.Produit;
import java.util.List;

public class GestionArticle {
    private IGestionArticleDAO articleDAO;

    public GestionArticle(IGestionArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    // Method to add a product
    public void ajoutProduit(Produit produit) {
        articleDAO.ajoutProduit(produit);
    }

    // Method to list all products
    public List<Produit> listerProduits() {
        return articleDAO.listerProduits();
    }

    // Method to get a product by its ID
    public Produit getProduitById(int id) {
        return articleDAO.getProduitById(id);
    }

    // Method to update a product
    public void modifierProduit(Produit produit) {
        articleDAO.modifierProduit(produit);
    }

    // Method to delete a product by its ID
    public void supprimerProduit(int id) {
        articleDAO.supprimerProduit(id);
    }
}

