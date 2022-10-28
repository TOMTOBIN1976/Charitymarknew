package org.wit.charitymark.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.charitymark.R
import org.wit.charitymark.adapters.CharitymarkAdapter
import org.wit.charitymark.adapters.CharitymarkListener
import org.wit.charitymark.databinding.ActivityCharitymarkListBinding
import org.wit.charitymark.main.MainApp
import org.wit.charitymark.models.CharitymarkModel

class CharitymarkListActivity : AppCompatActivity(), CharitymarkListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivityCharitymarkListBinding
    private lateinit var refreshIntentLauncher : ActivityResultLauncher<Intent>

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
        //binding.recyclerView.adapter = CharitymarkAdapter(app.charitymarks.findAll())
        //binding.recyclerView.adapter = CharitymarkAdapter(app.charitymarks.findAll(),this)
        binding.recyclerView.layoutManager = layoutManager
        loadCharitymarks()

        registerRefreshCallback()
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
                refreshIntentLauncher.launch(launcherIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    // passing selected charity event to the activity (enabled via parcelable)
    override fun onCharitymarkClick(charitymark: CharitymarkModel) {
        val launcherIntent = Intent(this, CharitymarkActivity::class.java)
        launcherIntent.putExtra("charitymark_edit", charitymark)
        refreshIntentLauncher.launch(launcherIntent)
    }

    private fun registerRefreshCallback() {
        refreshIntentLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { loadCharitymarks() }
    }

    private fun loadCharitymarks() {
        showCharitymarks(app.charitymarks.findAll())
    }

    fun showCharitymarks (charitymarks: List<CharitymarkModel>) {
        binding.recyclerView.adapter = CharitymarkAdapter(charitymarks, this)
        binding.recyclerView.adapter?.notifyDataSetChanged()
    }
}
