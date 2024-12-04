import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    private int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio;
    }
}

public class CRUD {
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static int idCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- CRUD MENU ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Leer productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> crearProducto(scanner);
                case 2 -> leerProductos();
                case 3 -> actualizarProducto(scanner);
                case 4 -> eliminarProducto(scanner);
                case 5 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void crearProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(idCounter++, nombre, precio);
        productos.add(producto);
        System.out.println("Producto creado exitosamente: " + producto);
    }

    private static void leerProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Lista de productos ---");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private static void actualizarProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        Producto producto = buscarProducto(id);

        if (producto != null) {
            System.out.print("Ingrese el nuevo nombre: ");
            String nombre = scanner.next();
            System.out.print("Ingrese el nuevo precio: ");
            double precio = scanner.nextDouble();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            System.out.println("Producto actualizado exitosamente: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        Producto producto = buscarProducto(id);

        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static Producto buscarProducto(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
}