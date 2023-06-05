package inventario.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import inventario.modelo.Producto;

public class ProductoDao {
	
	private static List<Producto> listaProductos = new ArrayList<>();
	private static Integer llaveSecuencial = 1;
	static {
		Producto producto = new Producto();
		producto.setId(ProductoDao.llaveSecuencial++);
		producto.setNombre("camisa");
		producto.setDescripcion("camisa manga corta");
		producto.setTamano("s");
		producto.setColor("azul");
		producto.setProveedor("casa ropa");
		producto.setPrecio(20000);
		producto.setCantidad(20);
		listaProductos.add(producto);
	}
	
	public void guardar(Producto producto) {
		producto.setId(llaveSecuencial++);
		ProductoDao.listaProductos.add(producto);
	}
	
	public List<Producto> listar() {
		return ProductoDao.listaProductos;
	}

	public int eliminar(Integer id) {
		Iterator<Producto> iterator = listaProductos.iterator();
		while(iterator.hasNext()) {
			Producto producto = iterator.next();
			if(producto.getId() == id) {
				iterator.remove();
			}
		}
		return id;
	}

	public int modificar(String nombre, String descripcion, String tamano, String color, String proveedor, Integer precio, Integer id) {
		
		for(Producto producto: listaProductos) {
			if(producto.getId() == id) {
				producto.setNombre(nombre);
				producto.setDescripcion(descripcion);
				producto.setTamano(tamano);
				producto.setColor(color);
				producto.setProveedor(proveedor);
				producto.setPrecio(precio);
				break;
			}
		}
		return id;
	}
	
	public void stockIn(Integer id, Integer cantidad) {
		for(Producto producto: listaProductos) {
			if(producto.getId() == id) {
				producto.setCantidad(producto.getCantidad() + cantidad);
				break;
			}
		}
	}
	
	public boolean stockOut(Integer id, Integer cantidad) {
		for(Producto producto: listaProductos) {
			if(producto.getId() == id) {
				if(producto.getCantidad() < cantidad) {
					return false;
				}
				producto.setCantidad(producto.getCantidad() - cantidad);
				break;
			}
		}
		return true;
	}
}

