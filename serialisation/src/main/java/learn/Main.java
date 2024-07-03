package learn;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Le monstre du Locness", "Machin truc", "125300N"));
        books.add(new Book("La légende de Maui", "Maui", "403201B"));
        books.add(new Book("Le livre de la jungle", "Rudyard Kipling", "123456C"));

        Serializer.serialize(books, "books.bin");

        List<Book> deserializedBooks = Deserializer.deserialize("books.bin");
        for (Book book : deserializedBooks) {
            System.out.println(book);
        }
    }
}