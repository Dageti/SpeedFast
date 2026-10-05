<h1 align="center">Welcome to SpeedFast</h1>
<p>
</p>

> Sistema de asignación y despacho de pedidos para SpeedFast.
> 
> Aplica los principios de Programación Orientada a Objetos mediante herencia, y patron DAO para separar la logica del sistema y el acceso  a la base de datos.
>

## Estructura Semana 8

    Semana_8/
    ├── pom.xml
    ├── README.md
    ├── database/
    │   └── speedfast_db.sql
    └── src/
        └── main/
            └── java/
                └── cl/
                    ├── app/
                    │   └── Main.java
                    ├── dao/
                    │   ├── ConnectionDB.java
                    │   ├── EntregaDAO.java
                    │   ├── PedidoDAO.java
                    │   └── RepartidorDAO.java
                    ├── interfaces/
                    │   ├── Cancelable.java
                    │   ├── Despachable.java
                    │   └── Rastreable.java
                    ├── model/
                    │   ├── Entrega.java
                    │   ├── EstadoPedido.java
                    │   ├── Pedido.java
                    │   ├── PedidoComida.java
                    │   ├── PedidoEncomienda.java
                    │   ├── PedidoExpress.java
                    │   └── Repartidor.java
                    ├── services/
                    │   └── ControladorDeEnvios.java
                    └── view/
                        ├── VentanaAsignacionEntrega.java
                        ├── VentanaListaPedidos.java
                        ├── VentanaPrincipal.java
                        └── VentanaRegistroPedido.java

### Modelos

Contiene las clases que representan los pedidos, repartidores y entregas, incluyendo los distintos tipos de pedidos y sus estados.

| Clase | Descripción |
|---|---|
| `Pedido` | Clase abstracta con los datos comunes de los pedidos. |
| `PedidoComida` | Representa pedidos de comida. |
| `PedidoEncomienda` | Representa pedidos de encomienda. |
| `PedidoExpress` | Representa pedidos de entrega rápida. |
| `Repartidor` | Contiene los datos del repartidor. |
| `Entrega` | Registra el pedido, repartidor, fecha y hora de entrega. |
| `EstadoPedido` | Define los estados posibles de un pedido. |

### Acceso a datos

Gestiona la conexión con MySQL y las operaciones sobre la base de datos mediante JDBC y el patrón DAO.

| Clase | Descripción |
|---|---|
| `ConnectionDB` | Establece la conexión con MySQL. |
| `PedidoDAO` | Registra, consulta, actualiza y elimina pedidos. |
| `RepartidorDAO` | Registra y consulta repartidores. |
| `EntregaDAO` | Registra las entregas realizadas. |

### Servicios

Contiene la lógica principal que coordina las operaciones del sistema.

| Clase | Descripción |
|---|---|
| `ControladorDeEnvios` | Asigna pedidos a los repartidores y coordina el proceso de entrega. |

### Interfaz gráfica

| Ventana | Descripción |
|---|---|
| `VentanaPrincipal` | Muestra el menú principal y permite registrar repartidores. |
| `VentanaRegistroPedido` | Permite registrar nuevos pedidos. |
| `VentanaListaPedidos` | Muestra los pedidos y permite eliminar los pendientes. |
| `VentanaAsignacionEntrega` | Permite asignar repartidores y simular entregas. |

## Instrucciones de ejecución

> - Clonar repositorio.
> - Para ejecutar el proyecto, es necesario tener MySQL instalado y el servicio activo.
> - Iniciar el servidor MySQL, utilizando el puerto `3306`. 
> - Abrir MySQL en DBeaver o una herramienta similar. 
> - jecutar el script `database/speedfast_db.sql` para crear la base de datos y sus tablas.
> - Abrir la carpeta `semana_8` en un IDE compatible con Java (recomendado: IntelliJ IDEA).
> - Ejecutar `Main.java`.




## Author

👤 **Matías Rivas Gallardo**

* Github: [@dageti](https://github.com/dageti)