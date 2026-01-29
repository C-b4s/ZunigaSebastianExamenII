package ZSDataAccessComponent.ZSDTOs;

public class ZSSexoDTO {
    private Integer IdZSSexo;
    private String zsNombre;
    private String zsDescripcion;
    private String zsEstado;
    private String zsFechaCreacion;
    private String zsFechaModifica;
    
    public ZSSexoDTO() {
    }

    public ZSSexoDTO(String zsNombre, String zsDescripcion) {
        this.IdZSSexo = 0;
        this.zsNombre = zsNombre;
        this.zsDescripcion = zsDescripcion;
    }
    public ZSSexoDTO(Integer IdZSSexo, String zsNombre, String zsDescripcion, String zsEstado, String zsFechaCreacion,
            String zsFechaModifica) {
        this.IdZSSexo        = IdZSSexo;
        this.zsNombre        = zsNombre;
        this.zsDescripcion   = zsDescripcion;
        this.zsEstado        = zsEstado;
        this.zsFechaCreacion = zsFechaCreacion;
        this.zsFechaModifica = zsFechaModifica;
    }

    public Integer getIdZSSexo() {
        return IdZSSexo;
    }

    public void setIdZSSexo(Integer IdZSSexo) {
        this.IdZSSexo = IdZSSexo;
    }

    public String getZSNombre() {
        return zsNombre;
    }

    public void setZSNombre(String zsNombre) {
        this.zsNombre = zsNombre;
    }

    public String getZSDescripcion() {
        return zsDescripcion;
    }

    public void setZSDescripcion(String zsDescripcion) {
        this.zsDescripcion = zsDescripcion;
    }

    public String getZSEstado() {
        return zsEstado;
    }

    public void setZsEstado(String zsEstado) {
        this.zsEstado = zsEstado;
    }

    public String getZSFechaCreacion() {
        return zsFechaCreacion;
    }

    public void setZSFechaCreacion(String zsFechaCreacion) {
        this.zsFechaCreacion = zsFechaCreacion;
    }

    public String getZSFechaModifica() {
        return zsFechaModifica;
    }

    public void setZSFechaModifica(String zsFechaModifica) {
        this.zsFechaModifica = zsFechaModifica;
    }

    @Override
    public String toString() {
        return   "\n IdSexo               " + getIdZSSexo()
               + "\n Nombre               " + getZSNombre() 
               + "\n Descripcion          " + getZSDescripcion() 
               + "\n Estado               " + getZSEstado()  
               + "\n FechaCreacion        " + getZSFechaCreacion()
               + "\n FechaModifica        " + getZSFechaModifica();
    }
}
