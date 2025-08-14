<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Mis Pedidos - Kinalitos Clothes</title>
    <link rel="icon" type="image/x-icon" href="../Images/Logo_K.C.png">
    <link rel="stylesheet" href="../Styles/mispedidos.css">
</head>
<body>
    <!-- Header -->
    <header class="header">
        <nav class="nav">
            <a href="#" class="logo">KC</a>
            <ul class="nav-links">
                <li><a href="Controlador?menu=Principal">INICIO</a></li>
                <li><a href="Controlador?menu=vistaproducto">TIENDA</a></li>
                <li><a href="Controlador?menu=conocenos">NOSOTROS</a></li>
            </ul>
        </nav>
    </header>

    <!-- Contenido principal -->
    <main class="container">
        <h1 class="page-title">Mis Pedidos</h1>

        <!-- Pedido 1 -->
        <div class="pedido-card">
            <div class="pedido-header">
                <div class="pedido-numero">Pedido #KC001</div>
                <div class="pedido-estado estado-entregado">Entregado</div>
            </div>
            
            <div class="pedido-info">
                <div class="info-item">
                    <div class="info-label">Fecha del Pedido</div>
                    <div class="info-value">15 de Julio, 2025</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Hora</div>
                    <div class="info-value">14:30 PM</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Método de Pago</div>
                    <div class="info-value">Tarjeta de Crédito</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Dirección de Envío</div>
                    <div class="info-value">Zona 10, Guatemala City</div>
                </div>
            </div>

            <div class="pedido-total">
                <span class="total-label">Total del Pedido:</span>
                <span class="total-amount">Q 531.50</span>
            </div>

            <div class="pedido-actions">
                <a href="Controlador?menu=vistadetallepedido" class="btn btn-primary">Ver Detalles</a>
                <a href="Controlador?menu=VistaFacturaCliente" class="btn btn-secondary">Ver Factura</a>
                <a href="Controlador?menu=MetodoPago" class="btn btn-primary">Metodo Pago </a>
            </div>
        </div>

        <!-- Pedido 2 -->
        <div class="pedido-card">
            <div class="pedido-header">
                <div class="pedido-numero">Pedido #KC002</div>
                <div class="pedido-estado estado-enviado">Enviado</div>
            </div>
            
            <div class="pedido-info">
                <div class="info-item">
                    <div class="info-label">Fecha del Pedido</div>
                    <div class="info-value">18 de Julio, 2025</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Hora</div>
                    <div class="info-value">10:15 AM</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Método de Pago</div>
                    <div class="info-value">Efectivo Contra Entrega</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Dirección de Envío</div>
                    <div class="info-value">Zona 1, Guatemala City</div>
                </div>
            </div>

            <div class="pedido-total">
                <span class="total-label">Total del Pedido:</span>
                <span class="total-amount">Q 241.60</span>
            </div>

            <div class="pedido-actions">
                <a href="Controlador?menu=vistadetallepedido" class="btn btn-primary">Ver Detalles</a>
                <a href="Controlador?menu=VistaFacturaCliente" class="btn btn-secondary">Ver Factura</a>
                <a href="Controlador?menu=MetodoPago" class="btn btn-primary">Metodo Pago </a>
            </div>
        </div>

        <!-- Pedido 3 -->
        <div class="pedido-card">
            <div class="pedido-header">
                <div class="pedido-numero">Pedido #KC003</div>
                <div class="pedido-estado estado-pendiente">Pendiente</div>
            </div>
            
            <div class="pedido-info">
                <div class="info-item">
                    <div class="info-label">Fecha del Pedido</div>
                    <div class="info-value">20 de Julio, 2025</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Hora</div>
                    <div class="info-value">09:45 AM</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Método de Pago</div>
                    <div class="info-value">Transferencia Bancaria</div>
                </div>
                <div class="info-item">
                    <div class="info-label">Dirección de Envío</div>
                    <div class="info-value">Zona 15, Guatemala City</div>
                </div>
            </div>

            <div class="pedido-total">
                <span class="total-label">Total del Pedido:</span>
                <span class="total-amount">Q 350.00</span>
            </div>

            <div class="pedido-actions">
                <a href="Controlador?menu=vistadetallepedido" class="btn btn-primary">Ver Detalles</a>
                <a href="Controlador?menu=VistaFacturaCliente" class="btn btn-secondary">Ver Factura</a>
                <a href="Controlador?menu=MetodoPago" class="btn btn-primary">Metodo Pago </a>
            </div>
        </div>

        
    </main>
</body>
</html>
