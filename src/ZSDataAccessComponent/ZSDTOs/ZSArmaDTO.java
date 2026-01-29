package ZSDataAccessComponent.ZSDTOs;

public class ZSArmaDTO {
    public Integer IdZSArma           ;
    public Integer IdZSArmaTipo       ;
    public String  ZSNombre           ;
    public String  ZSDescripcion      ;
    public String  ZSEstado           ;
    public String  ZSFechaCreacion    ;
    public String  ZSFechaModificacion;

    public ZSArmaDTO() {}
    
    public ZSArmaDTO(String zSNombre, String zSDescripcion) {
        IdZSArma = 0;
        ZSNombre = zSNombre;
        ZSDescripcion = zSDescripcion;
    }

    public ZSArmaDTO(Integer idZSArma, Integer idZSArmaTipo, String zSNombre, String zSDescripcion, String zSEstado,String zSFechaCreacion, String zSFechaModificacion) {
        IdZSArma = idZSArma;
        IdZSArmaTipo = idZSArmaTipo;
        ZSNombre = zSNombre;
        ZSDescripcion = zSDescripcion;
        ZSEstado = zSEstado;
        ZSFechaCreacion = zSFechaCreacion;
        ZSFechaModificacion = zSFechaModificacion;
    }
    public Integer getIdZSArma() {
        return IdZSArma;
    }
    public void setIdZSArma(Integer idZSArma) {
        IdZSArma = idZSArma;
    }
    public Integer getIdZSArmaTipo() {
        return IdZSArmaTipo;
    }
    public void setIdZSArmaTipo(Integer idZSArmaTipo) {
        IdZSArmaTipo = idZSArmaTipo;
    }
    public String getZSNombre() {
        return ZSNombre;
    }
    public void setZSNombre(String zSNombre) {
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
        return   "\n IdSexo               " + getIdZSArmaTipo()
               + "\n Nombre               " + getZSNombre() 
               + "\n Descripcion          " + getZSDescripcion() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModificacion();
    }
}
