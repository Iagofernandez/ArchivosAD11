
package aleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
////       Gardar os contidos dos tres arrays seguintes nun ficheiro aleatorio 
//        (creado en modo lectura escritura)  tendo en conta que cada tres elementos 
//                que  ocupan a mesma posicion nos arrays representan 
//                        os campos dun rexistro dunha taboa de produtos , onde cada produto ten 
////      un codigo unha descricion e un prezo
    String[] codigo = {"a1", "a2", "a3"};
    String[] animal = {"perros", "gatos ", "pajaros"};
    int[] precio = {3, 4, 5};

        
        
        File fichero = new File("/home/oracle/Desktop/Eje10/texto12.txt");
       
        //Permite la escritura en un fichero
        //se usara para ver si es psoible escribir en un fichero
        RandomAccessFile ficheroRandom = new RandomAccessFile(fichero, "Acceso");

        String function = "Funciona";
//       A clase String ten un metodo denonimado format 
//        que permite dar formato a unha cadea cadea :  format("%" + width + "s", t)   
        System.out.println(String.format("%" + 40 + "s", function).replace(" ", "0"));

        //Bucle que permite la escritura
        //de los array d eobjetos
        int numero = 0;

        for (numero = 0; numero < precio.length; numero++) {

            String cod = codigo[numero];
            String desc = animal[numero];
            int prezo = precio[numero];

            ficheroRandom.writeChars(String.format("%-" + 3 + "s", cod).replace(" ", "0"));
            ficheroRandom.writeChars(String.format("%-" + 10 + "s", desc).replace(" ", "0"));
            ficheroRandom.writeInt(prezo);
    
    
    }
        //Permite posicionarse en un byte del fichero especifico
        // e imprimirlo
        ficheroRandom.seek((2 - 1) * 30);

        String cod = "";
        String desc = "";
        int precio1 = 0;
        char caracter;
        for (int i = 0; i < 3; i++) {

            caracter = ficheroRandom.readChar();
            if (caracter != '0') {

                cod += caracter;

            }

}
   for (int i = 0;i < 10; i++) {

            caracter = ficheroRandom.readChar();
            if (caracter != '0') {

                desc += caracter;

            }

        }

        precio1 = ficheroRandom.readInt();

        System.out.print(desc);

        ficheroRandom.close();

        Product producto = new Product(cod, desc, precio1);
        System.out.println(producto.toString());

    }

} 
//Creacion de un constructor productos
class Product {

    private String codigo;
    private String animal;
    private int precio;

    public Product() {

        codigo = "";
        animal = "";
        precio = 0;

    }

    public Product(String codigo, String animal, int precio) {

        this.codigo = codigo;
        this.animal = animal;
        this.precio = precio;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getAnimal() {
        return animal;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
return "Product{" + "codigo=" + codigo + ", animal=" + animal + ", precio=" + precio + '}';
}
}
