package com.app.dao;
import com.app.metier.Produit;
import java.util.*;

public interface IGestionArticleDAO {
    void ajoutProduit(Produit p);
    List<Produit> listerProduits();
    Produit getProduitById(int id);
    void modifierProduit(Produit p);
    void supprimerProduit(int id);

}
