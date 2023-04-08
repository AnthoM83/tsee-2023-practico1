package tsee.g14.anthony.practico1.data.persistencia;

import tsee.g14.anthony.practico1.commons.datatypes.CiudadanoDt;
import jakarta.ejb.Local;
import java.util.List;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadYaExisteException;

/**
 *
 * @author Anthony Mallada
 */
@Local
public interface CiudadanoPersistenciaLocal {
    public void crearCiudadano(CiudadanoDt c) throws EntidadYaExisteException;
    public void borrarCiudadano(String cedula) throws EntidadNoExisteException;
    public CiudadanoDt buscarCiudadano(String cedula) throws EntidadNoExisteException;
    public List<String> obtenerCiudadanos();
}
