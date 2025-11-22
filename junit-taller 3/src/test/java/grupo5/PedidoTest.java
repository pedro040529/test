package grupo5;

import base.Pedido;
import modelo.Producto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    @DisplayName("Test 1: Lista vacía de productos debe lanzar excepción")
    void testListaVaciaDeProductos() {
        List<Producto> productos = new ArrayList<>();
        double descuento = 10;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Pedido.calcularTotalPedido(productos, descuento)
        );
        
        assertEquals("Error: no hay productos en el pedido", exception.getMessage());
    }

    @Test
    @DisplayName("Test 2: Subtotal igual a 0 debe lanzar excepción")
    void testSubtotalIgualACero() {
        List<Producto> productos = List.of(
            new Producto("ProductoGratis", 0, 1)
        );
        double descuento = 10;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Pedido.calcularTotalPedido(productos, descuento)
        );
        
        assertEquals("Error: monto inválido", exception.getMessage());
    }

    @Test
    @DisplayName("Test 3: Descuento válido del 10%")
    void testDescuentoValido() {
        List<Producto> productos = List.of(
            new Producto("Laptop", 100.0, 2)
        );
        double descuento = 10;

        double resultado = Pedido.calcularTotalPedido(productos, descuento);

        assertEquals(180.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Test 4: Descuento extremo de 0%")
    void testDescuentoExtremo0Porciento() {
        List<Producto> productos = List.of(
            new Producto("Monitor", 100.0, 2)
        );
        double descuento = 0;

        double resultado = Pedido.calcularTotalPedido(productos, descuento);

        assertEquals(200.0, resultado, 0.01);
    }

    @Test
    @DisplayName("Test 5: Lista null debe lanzar excepción")
    void testListaNullDeProductos() {
        List<Producto> productos = null;
        double descuento = 10;

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> Pedido.calcularTotalPedido(productos, descuento)
        );
        
        assertEquals("Error: no hay productos en el pedido", exception.getMessage());
    }
}
