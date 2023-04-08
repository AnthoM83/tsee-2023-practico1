package tsee.g14.anthony.practico1.data.persistencia;

import tsee.g14.anthony.practico1.commons.datatypes.CiudadanoDt;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadYaExisteException;
import tsee.g14.anthony.practico1.data.entidades.Ciudadano;
import jakarta.ejb.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;

/**
 *
 * @author Anthony Mallada
 */
@Singleton
public class CiudadanoPersistencia implements CiudadanoPersistenciaLocal, CiudadanoPersistenciaRemote {

    Map<String, Ciudadano> ciudadanos = new HashMap();

    public void crearCiudadano(CiudadanoDt c) throws EntidadYaExisteException {
        if (!ciudadanos.containsKey(c.getCedula())) {
            ciudadanos.put(c.getCedula(), new Ciudadano(c.getNombreCompleto(), c.getCedula(), c.getFechaNacimiento(), c.getCorreo(), c.getSectorLaboral()));
        } else {
            throw new EntidadYaExisteException("Ya existe un usuario con esa cédula.");
        }
    }

    public void borrarCiudadano(String cedula) throws EntidadNoExisteException {
        if (ciudadanos.remove(cedula) == null) {
            throw new EntidadNoExisteException("No existe un usuario con esa cédula.");
        }
    }

    public CiudadanoDt buscarCiudadano(String cedula) throws EntidadNoExisteException {
        Ciudadano c = ciudadanos.get(cedula);
        if (c != null) {
            return new CiudadanoDt(c.getNombreCompleto(), c.getCedula(), c.getFechaNacimiento(), c.getCorreo(), c.getSectorLaboral());
        } else {
            throw new EntidadNoExisteException("No existe un usuario con esa cédula.");
        }
    }

    public List<String> obtenerCiudadanos() {
        return new ArrayList<>(ciudadanos.keySet());
    }

}
