package com.example.themoviesdb.ui.details

import android.media.Image
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.themoviesdb.DETAILS_ACTIVITY_PERSON
import com.example.themoviesdb.R
import com.example.themoviesdb.ViewModelFactory
import com.example.themoviesdb.data.Resource
import com.example.themoviesdb.data.error.ErrorManager
import com.example.themoviesdb.data.error.ErrorMapper
import com.example.themoviesdb.data.error.ErrorMapper_Factory
import com.example.themoviesdb.data.models.Person
import com.example.themoviesdb.data.models.PersonImages
import com.example.themoviesdb.data.models.PersonProfile
import com.example.themoviesdb.ui.base.BaseActivity
import com.example.themoviesdb.ui.people.PeopleAdapter
import com.example.themoviesdb.ui.utils.observe
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_person_details.*
import javax.inject.Inject

class PersonDetailsActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var personDetailsViewModel: PersonDetailsViewModel
    lateinit var adapter: ImagesAdapter
    lateinit var person: Person
    override fun initializeViewModel() {
        personDetailsViewModel = viewModelFactory.create(PersonDetailsViewModel::class.java)
    }

    override fun observeViewModel() {
        observe(personDetailsViewModel.personImagesLiveData, ::handlePersonImages)
    }

    private fun handlePersonImages(status: Resource<PersonImages>) {
        when (status) {
            is Resource.Loading -> showToast("Loading")
            is Resource.Success -> loadPersonImagesGrid(status.data?.images)
            is Resource.DataError -> {
                showToast(status.errorCode?.let {
                    ErrorManager(ErrorMapper()).getError(it).description
                }
                )
            }
        }
    }

    private fun loadPersonImagesGrid(images: ArrayList<PersonProfile>?) {
        if (images != null) {
            adapter.images = images
            adapter.notifyDataSetChanged()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_details)
        init_view()
        personDetailsViewModel.getPeople(person.id.toString())
    }

    private fun init_view() {
        person = Gson().fromJson(intent.getStringExtra(DETAILS_ACTIVITY_PERSON), Person::class.java)
        person_details_name.text = person.name
        person_details_role.text = person.knownGenre
        Picasso.get().load(person.getImageUrl()).into(person_details_image)
        adapter = ImagesAdapter()
        adapter.images = ArrayList()
        person_images_grid.adapter = adapter
        person_images_grid.layoutManager = GridLayoutManager(this,2)
    }
}