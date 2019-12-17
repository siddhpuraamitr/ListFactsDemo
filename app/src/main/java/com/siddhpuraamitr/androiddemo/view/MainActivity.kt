package com.siddhpuraamitr.androiddemo.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.siddhpuraamitr.androiddemo.R
import com.siddhpuraamitr.androiddemo.adapter.FactsAdapter
import com.siddhpuraamitr.androiddemo.databinding.ActivityMainBinding
import com.siddhpuraamitr.androiddemo.model.Fact
import com.siddhpuraamitr.androiddemo.model.Rows
import com.siddhpuraamitr.androiddemo.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var lvFacts: ListView
    lateinit var factsAdapter: FactsAdapter
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var mainActivityViewModel: MainActivityViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        swipeRefreshLayout = activityMainBinding.swipeRefreshLayout
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)

        lvFacts = activityMainBinding.lvFacts
        swipeRefreshLayout.setOnRefreshListener {
            getFacts()
            swipeRefreshLayout.isRefreshing = false
        }

        getFacts()
    }

    private fun getFacts() {
        mainActivityViewModel.getFact().observe(this,
            Observer<Fact> { fact ->
                showOnRecyclerView(fact.rows)
                supportActionBar?.title = fact.title
            })
    }

    private fun showOnRecyclerView(rows: ArrayList<Rows>) {

        factsAdapter = FactsAdapter(this, rows)
        lvFacts.adapter = factsAdapter
        factsAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // toggle nav drawer on selecting action bar app icon/title
        when (item.itemId) {
            R.id.menuRefresh -> getFacts()
            else -> super.onOptionsItemSelected(item)
        }
        return true
    }
}
