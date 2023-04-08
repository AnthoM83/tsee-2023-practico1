package tsee.g14.anthony.practico1.ejb.servicios;

import jakarta.ejb.Local;
import java.util.List;
import tsee.g14.anthony.practico1.commons.datatypes.CiudadanoDt;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadYaExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.MenorEdadException;

/**
 *
 * @author Anthony Mallada
 */
@Local
interface GestorCiudadanosLocal {
    public void altaCiudadano(CiudadanoDt c) throws EntidadYaExisteException, MenorEdadException;
    public void bajaCiudadano(String cedula) throws EntidadNoExisteException;
    public CiudadanoDt consultaCiudadano(String cedula) throws EntidadNoExisteException;
    public List<String> listaCiudadanos();
}
