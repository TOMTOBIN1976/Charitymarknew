package org.wit.charitymark.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.charitymark.R
import org.wit.charitymark.adapters.CharitymarkAdapter
import org.wit.charitymark.databinding.ActivityCharitymarkListBinding
import org.wit.charitymark.main.MainApp

class CharitymarkListActivity : AppCompatActivity() {

    lateinit var app: MainApp
    private lateinit var binding: ActivityCharitymarkListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharitymarkListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // enable the action bar with title
        binding.toolbar.title = title
        setSupportActionBar(binding.toolbar)

        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        //Replaced with memory store
        //binding.recyclerView.adapter = CharitymarkAdapter(app.charitymarks)
        binding.recyclerView.adapter = CharitymarkAdapter(app.charitymarks.findAll())
    }
    //override the method to load menu resource.
    // Single button on the action bar (calling menu_main.xml)
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    //respond to the button press - triggering the launch of the CharitymarkActivity
    // implements the menu event handler - if event is item_add, start CharitymarkActivity.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, CharitymarkActivity::class.java)
                startActivityForResult(launcherIntent,0)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
// Moved to charitymarkAdapter
//class CharitymarkAdapter constructor(private var charitymarks: List<CharitymarkModel>) :
//    RecyclerView.Adapter<CharitymarkAdapter.MainHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
//        val binding = CardCharitymarkBinding
//            .inflate(LayoutInflater.from(parent.context), parent, false)

//        return MainHolder(binding)
//    }

//    override fun onBindViewHolder(holder: MainHolder, position: Int) {
//        val charitymark = charitymarks[holder.adapterPosition]
//        holder.bind(charitymark)
//    }

//    override fun getItemCount(): Int = charitymarks.size

//    class MainHolder(private val binding : CardCharitymarkBinding) :
//        RecyclerView.ViewHolder(binding.root) {

//      fun bind(charitymark: CharitymarkModel) {
//            binding.charitymarkTitle.text = charitymark.title
//            binding.description.text = charitymark.description
//        }
//    }
//}