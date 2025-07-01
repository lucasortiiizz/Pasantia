
package modelo;

public class DetalleVenta {
    
    //atributos
    private int idDetalleVenta;
    private int idCabecera;
    private int idProducto;
    private String nombre;
    private int cantidad;   
    private double precioUnitario;
    private double subtotal;
    private double descuento;
    private double iva;
    private double totalPagar;
    private int estado;
    
    //constructor
    
    public DetalleVenta(){
        this.idDetalleVenta = 0;
        this.idCabecera = 0;
        this.idProducto = 0;
        this.nombre = " ";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
        this.subtotal = 0.0;
        this.descuento = 0.0;
        this.iva = 0.0;
        this.totalPagar = 0.0;
        this.estado = 0;
        
    //constructor sobrecargado

    
    }

    public DetalleVenta(int idDetalleVenta, int idCabecera, int idProducto, String nombre, int cantidad, double precioUnitario, double subtotal, double descuento, double iva, double totalPagar, int estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idCabecera = idCabecera;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.iva = iva;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }
    
 //get-set

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdCabecera() {
        return idCabecera;
    }

    public void setIdCabecera(int idCabecera) {
        this.idCabecera = idCabecera;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    //to string

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idCabecera=" + idCabecera + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + ", descuento=" + descuento + ", iva=" + iva + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }
    
}
