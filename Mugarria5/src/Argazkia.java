import java.util.Date;

public class Argazkia {
    int idArgazki;
    String izenburua;
    Date data;
    String fitxategia;
    int bistaratzeKop;
    int idArgazkilari;

    public Argazkia(int idArgazki, String izenburua, Date data, String fitxategia, int bistaratzeKop, int idArgazkilari) {
        this.idArgazki = idArgazki;
        this.izenburua = izenburua;
        this.data = data;
        this.fitxategia = fitxategia;
        this.bistaratzeKop = bistaratzeKop;
        this.idArgazkilari = idArgazkilari;
    }

    public int getIdArgazki() {
        return idArgazki;
    }

    public String getIzenburua() {
        return izenburua;
    }

    public Date getData() {
        return data;
    }

    public String getFitxategia() {
        return fitxategia;
    }

    public int getBistaratzeKop() {
        return bistaratzeKop;
    }

    public int getIdArgazkilari() {
        return idArgazkilari;
    }
}
