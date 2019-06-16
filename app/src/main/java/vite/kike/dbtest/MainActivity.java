package vite.kike.dbtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnNotaClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotasDB.setContext(this);
        NotasDB.borrarTodasNotas();
        Nota n1 = new Nota("test1", "cont1");
        NotasDB.insertNota(n1);
        Nota n2 = new Nota("test2", "cont2");
        NotasDB.insertNota(n2);
        NotasDB.borrarNota(n1);

        RecyclerView recyclerView = findViewById(R.id.notas_rv);
        RecyclerView.LayoutManager myLayoutManager;
        recyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecyclerView.Adapter myAdapter = new ListAdapter(NotasDB.getAllNotas(), this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onNotaClicked(int pos) {

    }
}
