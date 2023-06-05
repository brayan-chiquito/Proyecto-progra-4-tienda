package inventario.controller;

import java.util.List;

import inventario.dao.MoviminetoDao;
import inventario.modelo.Movimiento;

public class MovimientoController {
	
	private MoviminetoDao moviminetoDao;
	
	public MovimientoController() {
		this.moviminetoDao = new MoviminetoDao();
	}
	
	
	public int modificar(Integer cantidad, Integer id) {
		return moviminetoDao.modificar(cantidad,id);
	}

	public int eliminar(Integer id) {
		return moviminetoDao.eliminar(id);
	}

	public List<Movimiento> listar() {
		
		return moviminetoDao.listar();
	}

    public void guardar(String tipo, Integer producto_id, Movimiento movimiento) {
    	movimiento.setProducto_id(producto_id);
    	movimiento.setTipoString(tipo);
		moviminetoDao.guardar(movimiento);
	}

}
