<h1 align="center">Welcome to SpeedFast</h1>
<p>
</p>

> Sistema de asignación de repartidores para la empresa de repartos SpeedFast.
> Aplica los principios de Programación Orientada a Objetos mediante el uso de herencia, polimorfismo y sobrecarga de
> métodos.

## Estructura

    src/main/java/cl/
    ├── app/
    │   └── Main.java
    └── model/
        ├── Pedido.java
        ├── PedidoComida.java
        ├── PedidoEncomienda.java
        └── PedidoExpress.java

## Modelos

| Clase              | Descripción                                                                                    |
|--------------------|------------------------------------------------------------------------------------------------|
| `Pedido`           | Clase base con atributos comunes: idPedido, direccionEntrega y tipoPedido.                     |
| `PedidoComida`     | Hereda de `Pedido`. Sobrescribe la asignación para requerir un repartidor con mochila térmica. |
| `PedidoEncomienda` | Hereda de `Pedido`. Sobrescribe la asignación para incluir validación de peso y embalaje.      |
| `PedidoExpress`    | Hereda de `Pedido`. Sobrescribe la asignación priorizando la proxima salida a ruta.            |

## Instrucciones de ejecución

> - Clonar repositorio.
> - Abrir en un IDE compatible con JAVA.
> - Ejecutar `Main.java`

## Author

👤 **Matías Rivas Gallardo**

* Github: [@dageti](https://github.com/dageti)