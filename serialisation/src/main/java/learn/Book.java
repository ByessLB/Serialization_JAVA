package learn;

import java.io.Serializable;

public class Book implements Serializable{
    private String titre;
    private String auteur;
    private String isbn;

    public Book(String titre, String auteur, String isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book\n" +
        "{titre = \"" + titre + 
        "\", auteur = \"" + auteur + 
        "\", isbn = \"" + isbn + "\"}";
    }

}
