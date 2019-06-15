package vite.kike.dbtest;

public class UtilidadesSQL {

    public final static String NOMBRE_DATABASE = "Notas.db";
    public final static int VERSION_DATABASE = 1;

    public class TABLA_NOTAS {
        public final static String NOMBRE_TABLA = "notas";
        public static final String CAMPO_ID = "id";
        public final static String CAMPO_TITULO = "titulo";
        public final static String CAMPO_CONTENIDO = "contenido";
    }

    public final static String CREAR_TABLA_NOTAS =
            "CREATE TABLE " + TABLA_NOTAS.NOMBRE_TABLA + " (" +
                    TABLA_NOTAS.CAMPO_ID + " INTEGER, " +
                    TABLA_NOTAS.CAMPO_TITULO + " TEXT, " +
                    TABLA_NOTAS.CAMPO_CONTENIDO + " TEXT)";


    public static final String INSERT_NOTA_1 =
            " INSERT INTO " + TABLA_NOTAS.NOMBRE_TABLA +
                    " VALUES (" +
                    "'a'," +
                    "'b')";

    public final static String BORRAR_TABLA_NOTAS_SI_EXISTE =
            "DROP TABLE IF EXISTS " + TABLA_NOTAS.NOMBRE_TABLA;

}
