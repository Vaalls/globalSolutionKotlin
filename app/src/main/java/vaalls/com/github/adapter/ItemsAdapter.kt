package vaalls.com.github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vaalls.com.github.R
import vaalls.com.github.model.Praia

public class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val itens = mutableListOf<Praia>()

    fun removeItem(item: Praia){
        itens.remove(item);
        notifyDataSetChanged()
    }
    fun addItem(newItem: Praia){
        itens.add(newItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = itens.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itens[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.textView)
        val button = view.findViewById<ImageButton>(R.id.remove)

        fun bind(item: Praia){
            textView.text = item.name

            button.setOnClickListener{
                item.onRemove(item)
            }
        }
    }


}