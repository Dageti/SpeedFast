<h1 align="center">Welcome to SpeedFast</h1>
<p>
</p>

> Sistema de asignación y despacho de pedidos para SpeedFast.
> Aplica los principios de Programación Orientada a Objetos mediante herencia, clases
> abstractas, polimorfismo (sobrecarga y sobrescritura) e interfaces.

## Estructura Semana 3

    semana_3/src/main/java/cl/
    ├── app/
    │   └── Main.java
    ├── interfaces/
    │   ├── Despachable.java
    │   ├── Cancelable.java
    │   └── Rastreable.java
    ├── model/
    │   ├── Pedido.java
    │   ├── PedidoComida.java
    │   ├── PedidoEncomienda.java
    │   └── PedidoExpress.java
    └── service/
        └── ControladorDeEnvios.java

## Modelos

| Clase                 | Descripción                                                                                                                   |
|-----------------------|-------------------------------------------------------------------------------------------------------------------------------|
| `Pedido`              | Clase base abstracta con atributos comunes: idPedido, direccionEntrega, distanciaKm, repartidorAsignado y estadoPedido.       |
| `PedidoComida`        | Hereda de `Pedido`. Su tiempo de entrega es 15 minutos + 2 minutos por kilómetro.                                             |
| `PedidoEncomienda`    | Hereda de `Pedido`. Su tiempo de entrega es 20 minutos + 1.5 minutos por kilómetro, ajustado a entero.                        |
| `PedidoExpress`       | Hereda de `Pedido`. Su tiempo de entrega es 10 minutos, a menos que `distanciaKm` sea mayor a 5, en cuyo caso son 15 minutos. |
| `ControladorDeEnvios` | Servicio que registra los pedidos despachados/cancelados y expone el historial completo de entregas.                          |

## Interfaces

| Interfaz      | Método           | Responsabilidad                         |
|---------------|------------------|-----------------------------------------|
| `Despachable` | `despachar()`    | Marca el pedido como despachado.        |
| `Cancelable`  | `cancelar()`     | Marca el pedido como cancelado.         |
| `Rastreable`  | `verHistorial()` | Muestra el historial/estado del pedido. |

Las tres interfaces son implementadas por la clase abstracta `Pedido`, por lo que
`PedidoComida`, `PedidoEncomienda` y `PedidoExpress` las heredan automáticamente
(evitando código repetido entre subclases). `ControladorDeEnvios` implementa
`Rastreable` de forma independiente para exponer el historial general del sistema.

## Diagrama de clases generado con PUML

![Diagrama de Clases UML](diagrama.png)

## Cambios semana 3:

> - Creadas interfaces `Despachable`, `Cancelable` y `Rastreable`.
> - Clase `Pedido` ahora es abstracta y centraliza los contratos de comportamiento para eliminar duplicidad de código.
> - Creado `ControladorDeServicios` que gestiona el historial de pedidos.
> - Generado diagrama con PlantUML para automatizar el proceso en futuras entregas.

## Instrucciones de ejecución

> - Clonar repositorio.
> - Abrir la carpeta `semana_3` en un IDE compatible con Java (recomendado: IntelliJ IDEA).
> - Ejecutar `Main.java`.

## Author

👤 **Matías Rivas Gallardo**

* Github: [@dageti](https://github.com/dageti)