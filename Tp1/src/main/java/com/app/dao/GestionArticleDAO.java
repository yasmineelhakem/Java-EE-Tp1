package com.app.dao;

import java.sql.*;
import java.util.*;

import com.app.metier.Produit;

public class GestionArticleDAO implements IGestionArticleDAO{
    private Connection connection;

    public GestionArticleDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajoutProduit(Produit p) {
        String sql = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, p.getNom());
            statement.setString(2, p.getDescription());
            statement.setDouble(3, p.getPrix());
            statement.setString(4, p.getImage());

            statement.executeUpdate();
            System.out.println("Produit ajouté ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> listerProduits() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produits";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setImage(rs.getString("image"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduitById(int id) {
        Produit produit = null;
        String sql = "SELECT * FROM produits WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produit = new Produit();
                produit.setId(rs.getInt("id"));
                produit.setNom(rs.getString("nom"));
                produit.setDescription(rs.getString("description"));
                produit.setPrix(rs.getDouble("prix"));
                produit.setImage(rs.getString("image"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produit;
    }


    @Override
    public void modifierProduit(Produit p) {
        String sql = "UPDATE produits SET nom = ?, description = ?, prix = ?, image = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, p.getNom());
            stmt.setString(2, p.getDescription());
            stmt.setDouble(3, p.getPrix());
            stmt.setString(4, p.getImage());
            stmt.setInt(5, p.getId());

            stmt.executeUpdate();
            System.out.println("Produit modifié ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void supprimerProduit(int id) {
        String sql = "DELETE FROM produits WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produit supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
