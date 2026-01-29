package ZSDataAccessComponent.ZSDTOs;

public class ZSArmaTipoDTO {
    public Integer IdZSArmaTipo       ;
    public Integer ZSNombre           ;
    public String  ZSDescripcion      ;
    public String  ZSEstado           ;
    public String  ZSFechaCreacion    ;
    public String  ZSFechaModificacion;

    public ZSArmaTipoDTO() {}

    public ZSArmaTipoDTO(Integer zSNombre, String zSDescripcion) {
        IdZSArmaTipo = 0;
        ZSNombre = zSNombre;
        ZSDescripcion = zSDescripcion;
    }

    public ZSArmaTipoDTO(Integer idZSArmaTipo, Integer zSNombre, String zSDescripcion, String zSEstado, String zSFechaCreacion, String zSFechaModificacion) {
        IdZSArmaTipo        = idZSArmaTipo;
        ZSNombre            = zSNombre;
        ZSDescripcion       = zSDescripcion;
        ZSEstado            = zSEstado;
        ZSFechaCreacion     = zSFechaCreacion;
        ZSFechaModificacion = zSFechaModificacion;
    }
    public Integer getIdZSArmaTipo() {
        return IdZSArmaTipo;
    }
    public void setIdZSArmaTipo(Integer idZSArmaTipo) {
        IdZSArmaTipo = idZSArmaTipo;
    }
    public Integer getZSNombre() {
        return ZSNombre;
    }
    public void setZSNombre(Integer zSNombre) {
        ZSNombre = zSNombre;
    }
    public String getZSDescripcion() {
        return ZSDescripcion;
    }
    public void setZSDescripcion(String zSDescripcion) {
        ZSDescripcion = zSDescripcion;
    }
    public String getZSEstado() {
        return ZSEstado;
    }
    public void setZSEstado(String zSEstado) {
        ZSEstado = zSEstado;
    }
    public String getZSFechaCreacion() {
        return ZSFechaCreacion;
    }
    public void setZSFechaCreacion(String zSFechaCreacion) {
        ZSFechaCreacion = zSFechaCreacion;
    }
    public String getZSFechaModificacion() {
        return ZSFechaModificacion;
    }
    public void setZSFechaModificacion(String zSFechaModificacion) {
        ZSFechaModificacion = zSFechaModificacion;
    }

    @Override
    public String toString() {
        return   "\n IdArmaTipo           " + getIdZSArmaTipo()
               + "\n Nombre               " + getZSNombre() 
               + "\n Descripcion          " + getZSDescripcion() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModificacion();
    }

    
}
