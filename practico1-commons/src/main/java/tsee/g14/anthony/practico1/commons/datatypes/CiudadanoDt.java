package tsee.g14.anthony.practico1.commons.datatypes;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Anthony Mallada
 */
public class CiudadanoDt implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nombreCompleto;
    private String cedula;
    private LocalDate fechaNacimiento ;
    private String correo;
    private SectorLaboral sectorLaboral;

    public CiudadanoDt(String nombreCompleto, String cedula, LocalDate fechaNacimiento, String correo, SectorLaboral sectorLaboral) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.sectorLaboral = sectorLaboral;
    }

    public SectorLaboral getSectorLaboral() {
        return sectorLaboral;
    }
    
    public void setSectorLaboral(SectorLaboral sectorLaboral) {
        this.sectorLaboral = sectorLaboral;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Nombre completo = " + nombreCompleto + "\n" + 
                "Cédula = " + cedula + "\n" +
                "Fecha de nacimiento = " + fechaNacimiento + "\n" + 
                "Correo electrónico = " + correo + "\n" +
                "Sector Laboral = " + sectorLaboral;
    }
    
}
