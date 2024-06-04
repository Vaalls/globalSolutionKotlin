package vaalls.com.github

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.recyclerview.widget.RecyclerView
import vaalls.com.github.adapter.ItemsAdapter
import vaalls.com.github.model.Praia

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter();
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.inserir)
        val nomePraia = findViewById<EditText>(R.id.nomePraia)
        val nomeCidade = findViewById<EditText>(R.id.nomeCidade)
        val nomeEstado = findViewById<EditText>(R.id.nomeEstado)

        button.setOnClickListener{
            if(nomePraia.text.isEmpty() || nomePraia.text.toString().length < 4){
                nomePraia.error = "Preencha um valor ou digite mais que 4 caracteres"
                return@setOnClickListener
            }
            if(nomeCidade.text.isEmpty() || nomeCidade.text.toString().length < 4 ){
                nomeCidade.error = "Preencha um valor ou digite mais que 4 caracteres"
                return@setOnClickListener
            }
            if(nomeEstado.text.isEmpty() || nomeEstado.text.toString().length < 4){
                nomeEstado.error = "Preencha um valor ou digite mais que 4 caracteres"
                return@setOnClickListener
            }

            val item = Praia(
                name = nomePraia.text.toString(),
                cidade = nomeCidade.text.toString(),
                estado = nomeEstado.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )
            itemsAdapter.addItem(item)

            nomePraia.text
        }

    }
}
