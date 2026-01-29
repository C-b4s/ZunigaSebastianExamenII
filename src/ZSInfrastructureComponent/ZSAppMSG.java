package ZSInfrastructureComponent;

import javax.swing.JOptionPane;

public abstract class ZSAppMSG {
    private ZSAppMSG() {}
    public static final void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg, "🐜 ZSAntCiberDron", JOptionPane.INFORMATION_MESSAGE);
    }
    public static final void showMsgError(String msg){
        //JOptionPane.showMessageDialog(null, msg, msg, 0);
        JOptionPane.showMessageDialog(null, msg, "💀 ZSAntCiberDron", JOptionPane.OK_OPTION);
    }
    public static final boolean showConfirmYesNo(String msg){
        return (JOptionPane.showConfirmDialog(null, msg, "🐜 ZSAntCiberDron", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
}