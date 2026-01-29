package ZSDataAccessComponent.ZSDTOs;

public class ZSSoldadoDTO {
    public Integer IdZSSoldado        ;
    public Integer IdZSSexo           ;
    public String  ZSUsuario          ;
    public String  ZSContrasena       ;
    public String  ZSEstado           ;
    public String  ZSFechaCreacion    ;
    public String  ZSFechaModificacion;

    public ZSSoldadoDTO() {}

    public ZSSoldadoDTO(String zSUsuario, String zSContrasena) {
        IdZSSoldado = 0;
        ZSUsuario = zSUsuario;
        ZSContrasena = zSContrasena;
    }

    public ZSSoldadoDTO(Integer idZSSoldado, Integer idZSSexo, String zSUsuario, String zSContrasena, String zSEstado,
            String zSFechaCreacion, String zSFechaModificacion) {
        IdZSSoldado = idZSSoldado;
        IdZSSexo = idZSSexo;
        ZSUsuario = zSUsuario;
        ZSContrasena = zSContrasena;
        ZSEstado = zSEstado;
        ZSFechaCreacion = zSFechaCreacion;
        ZSFechaModificacion = zSFechaModificacion;
    }    

    public Integer getIdZSSoldado() {
        return IdZSSoldado;
    }
    public void setIdZSSoldado(Integer idZSSoldado) {
        IdZSSoldado = idZSSoldado;
    }
    public Integer getIdZSSexo() {
        return IdZSSexo;
    }
    public void setIdZSSexo(Integer idZSSexo) {
        IdZSSexo = idZSSexo;
    }
    public String getZSUsuario() {
        return ZSUsuario;
    }
    public void setZSUsuario(String zSUsuario) {
        ZSUsuario = zSUsuario;
    }
    public String getZSContrasena() {
        return ZSContrasena;
    }
    public void setZSContrasena(String zSContrasena) {
        ZSContrasena = zSContrasena;
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
        return   "\n IdSexo               " + getIdZSSexo()
               + "\n Usuario              " + getZSUsuario() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModificacion();
    }
    
}
