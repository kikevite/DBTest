package vite.kike.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NotasDB {

    private static Context context;

    public static void setContext(Context c) {
        context = c;
    }

    private static NotasDbHelper helper;

    private static NotasDbHelper getHelper() {
        if (helper == null) {
            helper = new NotasDbHelper();
        }
        return helper;
    }

    static class NotasDbHelper extends SQLiteOpenHelper {

        public NotasDbHelper() {
            super(context, UtilidadesSQL.NOMBRE_DATABASE, null, UtilidadesSQL.VERSION_DATABASE);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(UtilidadesSQL.CREAR_TABLA_NOTAS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
            //
        }
    }

    public static ArrayList<Nota> getAllNotas() {
        SQLiteDatabase db = getHelper().getReadableDatabase();

        String[] columnasConsultar = {
                UtilidadesSQL.TABLA_NOTAS.CAMPO_ID,
                UtilidadesSQL.TABLA_NOTAS.CAMPO_TITULO,
                UtilidadesSQL.TABLA_NOTAS.CAMPO_CONTENIDO
        };

        Cursor c = db.query(
                UtilidadesSQL.TABLA_NOTAS.NOMBRE_TABLA,
                columnasConsultar,
                null,
                null,
                null,
                null,
                null
        );

        ArrayList<Nota> listNotas = new ArrayList<>();

        if (c != null && c.getCount() > 0) {
            while (c.moveToNext()) {
                long id = c.getLong(c.getColumnIndexOrThrow(UtilidadesSQL.TABLA_NOTAS.CAMPO_ID));
                String titulo = c.getString(c.getColumnIndexOrThrow(UtilidadesSQL.TABLA_NOTAS.CAMPO_TITULO));
                String contenido = c.getString(c.getColumnIndexOrThrow(UtilidadesSQL.TABLA_NOTAS.CAMPO_CONTENIDO));
                listNotas.add(new Nota(id, titulo, contenido));
            }
        }

        if (c != null) {
            c.close();
        }

        db.close();
        return listNotas;
    }

    public static void insertNota(Nota nota) {
        SQLiteDatabase db = getHelper().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UtilidadesSQL.TABLA_NOTAS.CAMPO_TITULO, nota.getTitulo());
        values.put(UtilidadesSQL.TABLA_NOTAS.CAMPO_CONTENIDO, nota.getContenido());

        long id = db.insert(UtilidadesSQL.TABLA_NOTAS.NOMBRE_TABLA,null, values);

        db.close();
    }

    public static void modificaNota(Nota nota) {
        SQLiteDatabase db = getHelper().getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UtilidadesSQL.TABLA_NOTAS.CAMPO_TITULO, nota.getTitulo());
        values.put(UtilidadesSQL.TABLA_NOTAS.CAMPO_CONTENIDO, nota.getContenido());

        String where = "id = ?";
        String[] args = {Long.toString(nota.getId())};

        int res = db.update(UtilidadesSQL.TABLA_NOTAS.NOMBRE_TABLA, values, where, args);

        db.close();
    }

    public static void borrarNota(Nota nota) {
        SQLiteDatabase db = getHelper().getWritableDatabase();

        String where = UtilidadesSQL.TABLA_NOTAS.CAMPO_TITULO + " = ?";
        String[] args = {nota.getTitulo()};

        db.delete(UtilidadesSQL.TABLA_NOTAS.NOMBRE_TABLA, where, args);
        db.close();
    }

    public static void borrarTodasNotas() {
        SQLiteDatabase db = getHelper().getWritableDatabase();
        db.delete(UtilidadesSQL.TABLA_NOTAS.NOMBRE_TABLA, null, null);
        db.close();
    }

}
