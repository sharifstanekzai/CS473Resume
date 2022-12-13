package com.example.cs473resume

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.cs473resume.databinding.ActivityMainBinding
import com.example.cs473resume.databinding.FragmentAboutBinding
import com.example.cs473resume.databinding.FragmentExperienceBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExperienceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExperienceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentExperienceBinding
    private lateinit var experienceArrayList:ArrayList<ExperienceModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        var view:View= inflater.inflate(R.layout.fragment_experience, container, false)

        binding= FragmentExperienceBinding.inflate(inflater,container,false)
       // var view:View= binding.
        experienceArrayList= ArrayList<ExperienceModel>()
        experienceArrayList.add(ExperienceModel(".NET Developer","Apex Systems","2022",R.drawable.apex))
        experienceArrayList.add(ExperienceModel("Sr. IT Expert","MoF","2018",R.drawable.mof))
        experienceArrayList.add(ExperienceModel("ICT & Database Manager","MoF","2016",R.drawable.mof))
        experienceArrayList.add(ExperienceModel("Database Specialist","MoF","2016",R.drawable.mof))
        experienceArrayList.add(ExperienceModel("Database Developer","MAIL","2014",R.drawable.mail))

        try {
           // var expListView: ListView = binding.experienceListView
            binding.experienceListView.adapter = ExperienceAdapter(context as Activity, experienceArrayList)

        }
        catch (exp:java.lang.Exception
        ){}
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExperienceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExperienceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}