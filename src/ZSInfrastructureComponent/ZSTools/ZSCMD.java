package ZSInfrastructureComponent.ZSTools;

public class ZSCMD {
    private ZSCMD() {}

    public static void clear () {
        System.out.print("\033[H\033[2J");
        System. out.flush();
    }

    public static void println(String msg) {
        if(System.console() != null)
            System.out.println(ZSCMDColor.CYAN + msg + ZSCMDColor.RESET);
    }

    public static void printlnError (String msg) {
        if(System.console() != null)
            System.out.println(ZSCMDColor.RED + msg + ZSCMDColor.RESET);
    }
}   

