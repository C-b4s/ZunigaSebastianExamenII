package ZSBusinessLogicComponent.ZSEntities;

import java.util.List;

import ZSDataAccessComponent.ZSDAOs.ZSSoldadoDAO;
import ZSDataAccessComponent.ZSDTOs.ZSSoldadoDTO;
import ZSInfrastructureComponent.ZSAppException;

public class ZSSoldadoBL {
    public ZSSoldadoDAO zsSoldadoDAO;

    public ZSSoldadoBL() throws ZSAppException {
        this.zsSoldadoDAO = new ZSSoldadoDAO(ZSSoldadoDTO.class, "ZSSoldado", "IdZSSoldado");
    }

    public List<ZSSoldadoDTO> zsGetAll() throws Exception {
        List <ZSSoldadoDTO> zsList = zsSoldadoDAO.zsReadAll();
        for (ZSSoldadoDTO zsSoldado : zsList) {
            zsSoldado.getZSUsuario().toUpperCase();
        }
        return zsList;
    }

    public ZSSoldadoDTO zsGetBy(int idReg) throws Exception {
        return zsSoldadoDAO.zsReadBy(idReg);
    }

    public boolean zsAdd(ZSSoldadoDTO regDTO) throws Exception{
        return zsSoldadoDAO.zsCreate(regDTO);
    }

    public boolean zsUpdate(ZSSoldadoDTO regDTO) throws Exception{
        return zsSoldadoDAO.zsUpdate(regDTO);
    }

    public boolean zsDelete(int idReg) throws Exception{
        return zsSoldadoDAO.zsDelete(idReg);
    }
}
