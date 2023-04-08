package tsee.g14.anthony.practico1.console;

import tsee.g14.anthony.practico1.commons.datatypes.CiudadanoDt;
import tsee.g14.anthony.practico1.commons.datatypes.SectorLaboral;
import tsee.g14.anthony.practico1.commons.excepciones.MenorEdadException;
import tsee.g14.anthony.practico1.ejb.servicios.GestorCiudadanosRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadYaExisteException;

/**
 *
 * @author Anthony Mallada
 */
public class ClienteConsola {

    BufferedReader reader = null;
    Properties props;
    InitialContext ctx;

    {
        props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        props.put(Context.PROVIDER_URL, "remote+http://localhost:8080");

        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
        }

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws Exception {

        ClienteConsola clienteConsola = new ClienteConsola();
        clienteConsola.clienteConsolaLogica();
    }

    private void clienteConsolaLogica() throws Exception, NamingException {
        String jndiName = "ejb:practico1/practico1-ejb/GestorCiudadanosBean!tsee.g14.anthony.practico1.ejb.servicios.GestorCiudadanosRemote";
        GestorCiudadanosRemote gestorCiudadanos = null;
        try {
            gestorCiudadanos = (GestorCiudadanosRemote) ctx.lookup(jndiName);
        } catch (NamingException ex) {}

        int opcion = 0;
        while (opcion != 5) {
            mostrarConsola();
            String strOpcion = reader.readLine();
            opcion = Integer.parseInt(strOpcion);
            switch (opcion) {
                case 1:
                    altaCiudadanoConsola(gestorCiudadanos);
                    break;
                case 2:
                    bajaCiudadanoConsola(gestorCiudadanos);
                    break;
                case 3:
                    consultaCiudadanoConsola(gestorCiudadanos);
                    break;
                case 4:
                    listaCiudadanosConsola(gestorCiudadanos);
                    break;
                default:
                    opcion = 5;
                    salir();
                    break;
            }
        }
    }

    private void mostrarConsola() {
        System.out.println("\n****************************");
        System.out.println("   Gestor de Ciudadanos  ");
        System.out.println("****************************\n");
        System.out.println("1. Alta de Ciudadano");
        System.out.println("2. Baja de Ciudadano");
        System.out.println("3. Consulta de Ciudadano");
        System.out.println("4. Listado de Ciudadanos");
        System.out.println("5. Salir");
        System.out.println("Ingrese la opción deseada: ");
    }

    private void altaCiudadanoConsola(GestorCiudadanosRemote gestorCiudadanos) throws Exception {
        System.out.println("~~ Alta de Ciudadano ~~");
        System.out.println("Ingrese los datos del ciudadano que desea dar de alta");
        CiudadanoDt c = new CiudadanoDt(
                pedirString("Nombre completo:"),
                pedirString("Cédula:"),
                pedirFecha("Fecha de nacimiento (yyyy-MM-dd):"),
                pedirString("Correo electrónico:"),
                pedirSectorLaboral());
        try {
            gestorCiudadanos.altaCiudadano(c);
        } catch (MenorEdadException | EntidadYaExisteException ex) {
            System.out.println("\n ERROR: " + ex.getMessage());
        }
    }

    private void bajaCiudadanoConsola(GestorCiudadanosRemote gestorCiudadanos) throws IOException {
        System.out.println("~~ Baja de Ciudadano ~~");
        System.out.println("Ingrese la cédula del ciudadano que desea dar de baja: ");
        try {
            gestorCiudadanos.bajaCiudadano(pedirString("Cédula:"));
        } catch (EntidadNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void consultaCiudadanoConsola(GestorCiudadanosRemote gestorCiudadanos) throws IOException {
        System.out.println("~~ Consulta de Ciudadano ~~");
        System.out.println("Ingrese la cédula del ciudadano que desea consultar: ");
        String opcion = reader.readLine();
        try {
            System.out.print(gestorCiudadanos.consultaCiudadano(opcion).toString());
        } catch (EntidadNoExisteException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void listaCiudadanosConsola(GestorCiudadanosRemote gestorCiudadanos) {
       System.out.println("~~ Lista de Ciudadanos ~~");
       List<String> listaCiudadanos = gestorCiudadanos.listaCiudadanos();
       if (!listaCiudadanos.isEmpty()) {
           listaCiudadanos.forEach(ciudadano -> {
               System.out.println(ciudadano);
           });
       } else {
           System.out.println("No existen ciudadanos registrados en el sistema.");
       }
    }

    private void salir() {
        System.out.println("\n****** Ha salido del Gestor de Ciudadanos ****** ");
    }

    private String pedirString(String atributo) throws IOException {
        System.out.println(atributo);
        return reader.readLine();
    }

    private LocalDate pedirFecha(String atributo) throws IOException {
        System.out.println(atributo);
        String strFecha = reader.readLine();
        return LocalDate.parse(strFecha);
    }

    private SectorLaboral pedirSectorLaboral() throws IOException {
        System.out.println("a. Procesamiento y conservación de alimentos, bebidas y tabaco");
        System.out.println("b. Industria frigorífica");
        System.out.println("c. Pesca");
        System.out.println("d. Industria Textil");
        System.out.println("e. Industrias del Cuero, Vestimenta y Calzado");
        System.out.println("f. Industria de la madera, celulosa y papel");
        System.out.println("Ingrese el sector laboral al que pertenece: ");
        String opcion = reader.readLine();
        switch (opcion) {
            case ("a"):
                return SectorLaboral.ALIMENTOS_BEBIDAS_TABACO;
            case ("b"):
                return SectorLaboral.IND_FRIGORIFICA;
            case ("c"):
                return SectorLaboral.PESCA;
            case ("d"):
                return SectorLaboral.IND_TEXTIL;
            case ("e"):
                return SectorLaboral.IND_CUERO_VESTIMENTA_CALZADO;
            case ("f"):
                return SectorLaboral.IND_MADERA_CELULOSA_PAPEL;
            default:
                return null;
        }
    }

}
