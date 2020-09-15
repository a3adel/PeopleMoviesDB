package com.example.themoviesdb.ui.people

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currencyconverter.ui.utils.OnRecyclerViewItemClickListener
import com.example.themoviesdb.DETAILS_ACTIVITY_PERSON
import com.example.themoviesdb.R
import com.example.themoviesdb.ViewModelFactory
import com.example.themoviesdb.data.Resource
import com.example.themoviesdb.data.error.ErrorManager
import com.example.themoviesdb.data.error.ErrorMapper
import com.example.themoviesdb.data.models.People
import com.example.themoviesdb.data.models.Person
import com.example.themoviesdb.ui.base.BaseActivity
import com.example.themoviesdb.ui.details.PersonDetailsActivity
import com.example.themoviesdb.ui.utils.observe
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var peopleViewModel: PeopleViewModel
    lateinit var adapter: PeopleAdapter

    override fun initializeViewModel() {
        peopleViewModel = viewModelFactory.create(peopleViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(peopleViewModel.peopleLiveData, ::handlePeopleList)
    }


    private fun handlePeopleList(status: Resource<People>) {
        when (status) {
            is Resource.Loading -> showToast("Loading")
            is Resource.Success -> loadPeopleList(status?.data?.people)
            is Resource.DataError -> {
                showToast(status.errorCode?.let {
                    ErrorManager(ErrorMapper()).getError(it).description
                }
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init_views()
        peopleViewModel.getPeople()
    }

    private fun init_views() {
        people_rv.layoutManager = LinearLayoutManager(this)
        adapter = PeopleAdapter()

        adapter.people = ArrayList()
        adapter.onRecyclerViewItemClickListener = object : OnRecyclerViewItemClickListener {
            override fun onItemClicked(position: Int) {
                val peopleGson = Gson().toJson(adapter.people.get(position))
                val intent = Intent(this@MainActivity, PersonDetailsActivity::class.java)
                intent.putExtra(DETAILS_ACTIVITY_PERSON, peopleGson)
                startActivity(intent)
            }
        }
        people_rv.adapter = adapter
    }

    fun loadPeopleList(people: ArrayList<Person>?) {
        if (people != null) {
            adapter.people = people
            adapter.notifyDataSetChanged()
        }
    }
}