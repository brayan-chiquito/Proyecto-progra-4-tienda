package inventario.modelo;

import java.util.Date;

public class Pedido {
	private Integer id;
	private String proveedor;
	private Integer producto_id;
	private Integer cantidad;
	private Integer precio;
	
	public Pedido() {
	}
	
	
	public Pedido(String proveedor, Integer cantidad, Integer precio) {
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public Integer getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
