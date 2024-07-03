# Serialisation et désérialisation d'objets en Java

Dans ce code, nous allons voir comment sérialiser et désérialiser des objets en Java. La sérialisation consiste à convertir un objet en une séquence d'octets qui peuvent être stockés dans un fichier ou transmis sur un réseau. La désérialisation zconsiste à convertir une séquence d'octets en un objet.

## La classe `Book`

Tout d'abord, nous avons une classe `Book` qui représente un livre. Cette classe a trois attributs : `titre`, `auteur` et `isbn`. La classe implémente l'interface `Serializable`, ce qui signifie que ses objets peuvent être sérialisés.

```java
import java.io.Serializable;

public class Book implements Serializable {
    private String titre;
    private String auteur;
    private String isbn;

    // Construtor

    // Getters et Setters

    //toString()
}
```

## Sérialisation d'une liste d'objets `Book`

Ensuite, nous avons une méthode `serialize` qui prend une liste d'objets `Book` et les sérialise dans un fichier binaire. Dans cette méthode, nous utilisans la classe `ObjectOutputStream` pour sérialiser la liste. Nous créons un objet `ObjectOutputStream` en utilisant un objet `FileOutputStream` pour écrire dans le fichier. Nous utilisons ensuite la méthode `writeObject` pour écrire la liste d'objets dans le fichier.

```java
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializer {
    public static void serialize(List<Book> books, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            // Ecrit la liste d'objets dans le fichier binaire
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Désérialisation d'une liste d'objets `Book`

Nous avons également une méthode `deserialize` qui lit une liste d'objets `Book` à partir d'un fichier binaire et les renvoie.
Nous utilisons la classe `ObjectInputStream` pour lire les objets du fichier. Nous créons un objet `ObjectInputStream` en utilisant un objet `FileInputStream` pour lire à partir du fichier. Nous utilison ensuite la méthode `readObject` pour lire la liste d'objets à partir du fichier. Notez que nous devons effectuer un cast vers `List<Book>` car la méthode `readObject` renvoie un objet de type `Object`.

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializer {
    public static List<Book> deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            // lit la liste d'objets à partir du fichier binaire et effectue un cast vers List<Book>
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
```

## Exemple d'utilisation

Enfin, nous avons une classe `Main` qui crée une liste d'objets `Book`, les sérialise dans un fichier binaire, puis les désérialise et les affiche dans la console.

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Le monstre du locness", "Machin truc", "125300N"));
        books.add(new Book("La légende de Maui", "Maui", "403201B"));
        books.add(new Book("Le livre de la jungle", "Rudyard Kipling", "123456C"));

        // Sérialise la liste d'objets dans un fichier binaire
        Serializer.serialize(books, "books.bin");

        // Désérialise la liste d'objets à partir du fichier binaire et les affiche dans la console
        List<Book> deserializedBooks = Deserializer.deserialize("books.bin");
        for (Book book : deserializedBooks) {
            System.out.println(book);
        }
    }
}
```

Cela devrait créer un fichier `books.bin` contenant une liste sérialisée d'objets `Book`, puis lire ce fichier et afficher les objets `Book` correspondants dans la console."# Serialization_JAVA" 
