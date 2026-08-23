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

| Clase              | Descripción                                                                                                                             |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| `Pedido`           | Clase base abstacta con atributos comunes: idPedido, direccionEntrega y distanciaKm.                                                    |
| `PedidoComida`     | Hereda de `Pedido`. su tiempo de entrega es 15 miutos + 2 minutos por kilometro.                                                        |
| `PedidoEncomienda` | Hereda de `Pedido`. su tiempo de entrega es 20 miutos + 1.5 minutos por kilometro, ajustado a entero.                                   |
| `PedidoExpress`    | Hereda de `Pedido`. su tiempo de entrega es 10 minutos, amenos que `distanciaKm` sea mayor a 5, en ese caso se agregan 5 minutos extra. |

## Cambios semana 2: clases abstractas

> - La clase `Pedido` fue modificada a abstracta para funcionar como plantilla para sus subclases.
> - Agregada calculadora de tiempo de delivery en función a la distancia del pedido.

## Instrucciones de ejecución

> - Clonar repositorio.
> - Abrir en un IDE compatible con JAVA.
> - Ejecutar `Main.java`

## Author

👤 **Matías Rivas Gallardo**

* Github: [@dageti](https://github.com/dageti)