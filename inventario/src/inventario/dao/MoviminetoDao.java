package inventario.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import inventario.modelo.Movimiento;
import inventario.modelo.Producto;

public class MoviminetoDao {
	
	private static List<Movimiento> listaMoviminetos = new ArrayList<>();
	private static Integer llaveSecuencial = 1;
	static {
		Movimiento movimiento = new Movimiento();
		movimiento.setId(llaveSecuencial++);
		movimiento.setTipoString("entrada");
		movimiento.setProducto_id(1);
		movimiento.setCantidad(20);
		movimiento.setFecha();
		listaMoviminetos.add(movimiento);
	}
	
	public void guardar(Movimiento movimiento){
		movimiento.setId(llaveSecuencial++);
		MoviminetoDao.listaMoviminetos.add(movimiento);
	}
	
	public List<Movimiento> listar() {
		return MoviminetoDao.listaMoviminetos;
	}

	public int eliminar(Integer id) {
		Iterator<Movimiento> iterator = listaMoviminetos.iterator();
		while(iterator.hasNext()) {
			Movimiento movimiento = iterator.next();
			if(movimiento.getId() == id) {
				iterator.remove();
			}
		}
		return id;
	}

	public int modificar(Integer cantidad, Integer id) {
		
		for(Movimiento movimineto: listaMoviminetos) {
			if(movimineto.getId() == id) {
				movimineto.setCantidad(cantidad);
				break;
			}
		}
		return id;
	}
	
}

