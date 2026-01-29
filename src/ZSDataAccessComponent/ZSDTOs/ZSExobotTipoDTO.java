package ZSDataAccessComponent.ZSDTOs;

public class ZSExobotTipoDTO {
    public Integer IdZSExobotTipo     ;
    public Integer ZSNombre           ;
    public String  ZSDescripcion      ;
    public String  ZSEstado           ;
    public String  ZSFechaCreacion    ;
    public String  ZSFechaModificacion;

    public ZSExobotTipoDTO() {
    }

    public ZSExobotTipoDTO(Integer zSNombre, String zSDescripcion) {
        IdZSExobotTipo  = 0;
        ZSNombre        = zSNombre;
        ZSDescripcion   = zSDescripcion;
    }

    public ZSExobotTipoDTO(Integer idZSExobotTipo, Integer zSNombre, String zSDescripcion, String zSEstado, String zSFechaCreacion, String zSFechaModificacion) {
        IdZSExobotTipo      = idZSExobotTipo;
        ZSNombre            = zSNombre;
        ZSDescripcion       = zSDescripcion;
        ZSEstado            = zSEstado;
        ZSFechaCreacion     = zSFechaCreacion;
        ZSFechaModificacion = zSFechaModificacion;
    }

    public Integer getIdZSExobotTipo() {
        return IdZSExobotTipo;
    }
    public void setIdZSExobotTipo(Integer idZSExobotTipo) {
        IdZSExobotTipo = idZSExobotTipo;
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
        return   "\n IdZSExobotTipo       " + getIdZSExobotTipo()
               + "\n Nombre               " + getZSNombre() 
               + "\n Descripcion          " + getZSDescripcion() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModificacion();
    }
    
}
