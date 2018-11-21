package main.java.com.example.echo;

import java.util.HashMap;


public class UsuarioFactory {
	 private HashMap<String, IUsuario> list = new HashMap<String, IUsuario>();
	    
	    public void CrearUsuario (String index, IUsuario usuario){
	        list.put(index, usuario);
	    }	    
	    public IUsuario ConsultarUsuario(String index){
	        return (IUsuario)list.get(index);
	    }	    
	    public void EliminarUsuario (String Index){
	    	list.remove(Index);
	    }
	    public void ModificarUsuario(String index, IUsuario usuario){
	    	list.get(index).setNombre(usuario.getNombre());
	    	list.get(index).setCorreo(usuario.getCorreo());
	    	list.get(index).setContrasena(usuario.getContrasena());
	    	list.get(index).setTipo(usuario.getTipo());
	    }
}
