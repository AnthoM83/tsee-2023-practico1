package tsee.g14.anthony.practico1.ejb.servicios;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import tsee.g14.anthony.practico1.commons.datatypes.CiudadanoDt;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadNoExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.EntidadYaExisteException;
import tsee.g14.anthony.practico1.commons.excepciones.MenorEdadException;
import tsee.g14.anthony.practico1.data.persistencia.CiudadanoPersistenciaLocal;

/**
 *
 * @author Anthony Mallada
 */
@Stateless
public class GestorCiudadanosBean implements GestorCiudadanosLocal, GestorCiudadanosRemote {

    @EJB
    CiudadanoPersistenciaLocal ciudadanoPersistencia;

    public GestorCiudadanosBean() {
    }

    public void altaCiudadano(CiudadanoDt c) throws EntidadYaExisteException, MenorEdadException {
        if ((Period
                .between(c.getFechaNacimiento(), LocalDate.now()))
                .getYears() > 18) {
            ciudadanoPersistencia.crearCiudadano(c);
        } else {
            throw new MenorEdadException("Debe ser mayor de edad para registrarse.");
        }
    }

    public void bajaCiudadano(String cedula) throws EntidadNoExisteException {
        ciudadanoPersistencia.borrarCiudadano(cedula);
    }

    public CiudadanoDt consultaCiudadano(String cedula) throws EntidadNoExisteException {
        return ciudadanoPersistencia.buscarCiudadano(cedula);
    }

    public List<String> listaCiudadanos() {
        return ciudadanoPersistencia.obtenerCiudadanos();
    }

}
