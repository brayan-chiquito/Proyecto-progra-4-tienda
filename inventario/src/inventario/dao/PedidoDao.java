package inventario.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import inventario.modelo.Pedido;
import inventario.modelo.Producto;

public class PedidoDao {
	
	private static List<Pedido> listaPedidos = new ArrayList<>();
	private static Integer llaveSecuencial = 1;
	static {
		Pedido pedido = new Pedido();
		pedido.setId(llaveSecuencial++);
		pedido.setProveedor("s&m");
		pedido.setProducto_id(1);
		pedido.setCantidad(10);
		pedido.setPrecio(50000);
		listaPedidos.add(pedido);
	}
	
	public void guardar(Pedido pedido) {
		pedido.setId(llaveSecuencial++);
		PedidoDao.listaPedidos.add(pedido);
	}
	
	public List<Pedido> listar() {
		return PedidoDao.listaPedidos;
	}

	public int eliminar(Integer id) {
		Iterator<Pedido> iterator = listaPedidos.iterator();
		while(iterator.hasNext()) {
			Pedido pedido = iterator.next();
			if(pedido.getId() == id) {
				iterator.remove();
			}
		}
		return id;
	}

	public int modificar(String proveedor, Integer cantidad, Integer precio, Integer id) {
		
		for(Pedido pedido: listaPedidos) {
			if(pedido.getId() == id) {
				pedido.setProveedor(proveedor);
				pedido.setCantidad(cantidad);
				pedido.setPrecio(precio);
				break;
			}
		}
		return id;
	}
	
}

