package com.example.echo;

public abstract class Usuario implements IUsuario {
	
	private String Nombre;
	private String Correo;
	private String Contrasena;
	private String Tipo;
	
	public Usuario(String nombre, String correo, String contrasena, String tipo) {		
		Nombre = nombre;
		Correo = correo;
		Contrasena = contrasena;
		Tipo = tipo;
	}
	
	public Usuario() {		
	}
	
	@Override
    public void setNombre(String nombre){
        Nombre = nombre;
    }

	@Override
	public void setTipo(String tipo) {
		Tipo= tipo;		
	}
    
    @Override
    public void setCorreo(String correo){
        Correo = correo;
    }
    
    @Override
    public void setContrasena(String contrasena){
        Contrasena = contrasena;
    }
    
    @Override
    public String getNombre(){
        return Nombre;
    }
    
    @Override
    public String getCorreo(){
        return Correo;
    }
    
    @Override
    public String getContrasena(){
        return Contrasena;
    }
    @Override
	public String getTipo() {
		return Tipo;
	}

    
}
