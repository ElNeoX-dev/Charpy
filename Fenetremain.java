public class Fenetremain {
    public static void main(String[] args) {
        Pendule p = new Pendule(1, 500, 0, 0);
        Eprouvette e = new Eprouvette();
        Fenetre maFenetre = new Fenetre(p, e);
    }
}
