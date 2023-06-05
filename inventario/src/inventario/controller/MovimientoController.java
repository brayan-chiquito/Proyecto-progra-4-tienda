package inventario.controller;

import java.util.List;

import inventario.dao.MoviminetoDao;
import inventario.dao.ProductoDao;
import inventario.modelo.Movimiento;

public class MovimientoController {
	private ProductoDao productoDao;
	
	private MoviminetoDao moviminetoDao;
	
	public MovimientoController() {
		this.moviminetoDao = new MoviminetoDao();
		this.productoDao = new ProductoDao();
	}
	
	
	public int modificar(Integer cantidad, Integer id, Integer idProducto) {
//		return moviminetoDao.modificar();
		return 0;
	}

	public int eliminar(Integer id, Integer idProducto, Integer cantidad, String tipo) {
		if(tipo == "Entrada") {
    		boolean stockOut = productoDao.stockOut(idProducto, cantidad);
			if(stockOut == false) {
				return 0;
			}
    	}else {
    		productoDao.stockIn(idProducto, cantidad);
		}
		
		return moviminetoDao.eliminar(id);
	}

	public List<Movimiento> listar() {
		
		return moviminetoDao.listar();
	}

    public boolean guardar(String tipo, Integer producto_id, Movimiento movimiento) {
    	movimiento.setProducto_id(producto_id);
    	movimiento.setTipoString(tipo);
    	if(movimiento.getTipoString() == "Entrada") {
    		productoDao.stockIn(producto_id, movimiento.getCantidad());
    	}else {
			boolean stockOut = productoDao.stockOut(producto_id, movimiento.getCantidad());
			if(stockOut == false) {
				return false;
			}
		}
		moviminetoDao.guardar(movimiento);
		return true;
	}

}
