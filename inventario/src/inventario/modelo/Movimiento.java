package inventario.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JTextField;

public class Movimiento {
	private Integer id;
	private String tipoString;
	private Integer producto_id;
	private Integer cantidad;
	private LocalDateTime fecha;
	
	
	public Movimiento() {
	}
	public Movimiento(Integer cantidad) {
		this.cantidad = cantidad;
		this.fecha = LocalDateTime.now();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoString() {
		return tipoString;
	}
	public void setTipoString(String tipoString) {
		this.tipoString = tipoString;
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
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha() {
		this.fecha = LocalDateTime.now();
	}
	
	
}
