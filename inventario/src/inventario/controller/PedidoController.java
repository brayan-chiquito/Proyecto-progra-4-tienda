package inventario.controller;

import java.util.List;

import inventario.dao.PedidoDao;
import inventario.modelo.Pedido;

public class PedidoController {
	
	private PedidoDao pedidoDao;;
	
	public PedidoController() {
		this.pedidoDao = new PedidoDao();
	}
	
	
	public int modificar(String proveedor, Integer cantidad, Integer precio, Integer id) {
		return pedidoDao.modificar(proveedor,cantidad,precio,id);
	}

	public int eliminar(Integer id) {
		return pedidoDao.eliminar(id);
	}

	public List<Pedido> listar() {
		
		return pedidoDao.listar();
	}

    public void guardar(Pedido pedido, Integer producto_id) {
    	pedido.setProducto_id(producto_id);
		pedidoDao.guardar(pedido);
	}

}
