package ZSDataAccessComponent.ZSDTOs;

public class ZSExobotDTO {
    public Integer IdZSExobot         ;
    public Integer IdZSExobotTipo     ;
    public Integer IdZSArmaTipo       ;
    public String  ZSEstado           ;
    public String  ZSEntreno          ;
    public Integer ZSNoAccion         ;
    public String  ZSFechaCreacion    ;
    public String  ZSFechaModificacion;
    public ZSExobotDTO() {}

    public ZSExobotDTO(Integer idZSExobotTipo, String zSEntreno, Integer zSNoAccion) {
        IdZSExobot = 0;
        IdZSExobotTipo = idZSExobotTipo;
        ZSEntreno = zSEntreno;
        ZSNoAccion = zSNoAccion;
    }

    public ZSExobotDTO(Integer idZSExobot, Integer idZSExobotTipo, String zSEstado, String zSEntreno, Integer zSNoAccion, String zSFechaCreacion, String zSFechaModificacion) {
        IdZSExobot          = idZSExobot;
        IdZSExobotTipo      = idZSExobotTipo;
        IdZSArmaTipo        = 0;
        ZSEstado            = zSEstado;
        ZSEntreno           = zSEntreno;
        ZSNoAccion          = zSNoAccion;
        ZSFechaCreacion     = zSFechaCreacion;
        ZSFechaModificacion = zSFechaModificacion;
    }
    public Integer getIdZSExobot() {
        return IdZSExobot;
    }
    public void setIdZSExobot(Integer idZSExobot) {
        IdZSExobot = idZSExobot;
    }
    public Integer getIdZSExobotTipo() {
        return IdZSExobotTipo;
    }
    public void setIdZSExobotTipo(Integer idZSExobotTipo) {
        IdZSExobotTipo = idZSExobotTipo;
    }
    public Integer getIdZSArmaTipo() {
        return IdZSArmaTipo;
    }
    public void setIdZSArmaTipo(Integer idZSArmaTipo) {
        IdZSArmaTipo = idZSArmaTipo;
    }
    public String getZSEstado() {
        return ZSEstado;
    }
    public void setZSEstado(String zSEstado) {
        ZSEstado = zSEstado;
    }
    public String getZSEntreno() {
        return ZSEntreno;
    }
    public void setZSEntreno(String zSEntreno) {
        ZSEntreno = zSEntreno;
    }
    public Integer getZSNoAccion() {
        return ZSNoAccion;
    }
    public void setZSNoAccion(Integer zSNoAccion) {
        ZSNoAccion = zSNoAccion;
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
        return   "\n IdSexo               " + getIdZSExobot()
               + "\n Entreno              " + getZSEntreno() 
               + "\n No. Accion           " + getZSNoAccion() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModificacion();
    }
    
}
