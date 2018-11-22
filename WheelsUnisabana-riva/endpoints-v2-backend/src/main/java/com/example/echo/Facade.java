package main.java.com.example.echo;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

@Api(
	    name = "facade",
	    version = "v1",
	    namespace =
	    @ApiNamespace(
	        ownerDomain = "echo.example.com",
	        ownerName = "echo.example.com",
	        packagePath = ""
	    ),
	    // [START_EXCLUDE]
	    issuers = {
	        @ApiIssuer(
	            name = "firebase",
	            issuer = "https://securetoken.google.com/wheels20181019",
	            jwksUri =
	                "https://www.googleapis.com/service_accounts/v1/metadata/x509/securetoken@system"
	                    + ".gserviceaccount.com"
	        )
	    },
	    		issuerAudiences = {
	    		        @ApiIssuerAudience(name = "firebase", audiences = "el-que-yo-quiera")
	    		    }
	// [END_EXCLUDE]
	)

public class Facade 
{
	/*riva hecho*/
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	HashMap<Long,String> sesiones = new HashMap<Long,String>();
	ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 

	Pasajero pas = new Pasajero("Juan", "juan", "juan", "pasajero");
	Reserva res = new Reserva(pas,"Ruta 1", 2.0, 2.0, 55, 1);
	Reserva res1 = new Reserva(pas,"Ruta 2", 3.0, 3.0, 33, 4);
	
	//[START echo_method]
	 @ApiMethod(name = "eliminar", path = "reservaelim")
	 public ArrayList eliminarReserva(@Named("n") Integer idReserva)
	 {
		 usuarios.add(pas);
		 reservas.add(res);
		 reservas.add(res1);
		 
		 for (int i = 0; i < reservas.size(); i++) 
		 {
			if(idReserva==reservas.get(i).getId())
			{
				reservas.remove(i);
			}	
		 }
		 
		 return reservas;
	 }  
	 // [END echo_method]

}
