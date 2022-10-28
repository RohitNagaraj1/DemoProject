import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Product {
    Integer id;
    String name;
    Double price;

    public Product(Integer id, String name, Double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public Double getPrice()
    {
        return this.price;
    }



    @Override
    public String toString()
    {
        return "Product{" + 
                "id=" + id +
                ",  name='" + name + '\'' +
                ",  price=" + price +
                '}';
    }
}

class Implementation {
    public static Long getProductCount(List<Product> list, String productName)
    {
        return list.stream().filter(i -> i.getName().contains(productName)).count();
    }

    public static Product getModelDetails(List<Product> list, String productName, int id)
    {
        for (Product p : list)
        {
            if (p.getName().equals(productName) && p.getId().equals(id))
                return p;
        }
        return null;
    }
}

public class Source1 {
    public static void main(String[] args) throws Exception{
        Product pr1 = new Product(1, "Paella Valenciana", 15.0);
        Product pr2 = new Product(2, "Gazpacho", 25.50);
        Product pr3 = new Product(3, "Bandeja Paisa", 35.50);
        Product pr4 = new Product(4, "Tortilla", 15.0);

        List<Product> products = Arrays.asList(pr1, pr2, pr3, pr4);
        Long count = Implementation.getProductCount(products, "Tortilla");
        Product product = Implementation.getModelDetails(products, "Tortilla", 4);
        System.out.println(count);
        System.out.println(product.toString());
    }
}
