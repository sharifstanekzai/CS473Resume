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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentAboutBinding
    private lateinit var educationArrayList:ArrayList<EducationModel>
    private lateinit var certificationArrayList:ArrayList<CertificationModel>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=FragmentAboutBinding.inflate(layoutInflater)

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
        var view:View= inflater.inflate(R.layout.fragment_about, container, false)

        educationArrayList= ArrayList<EducationModel>()
        educationArrayList.add(EducationModel("Bachelors","Bakhtar University","2012",R.drawable.bu))
        educationArrayList.add(EducationModel("Masters","Maharishi Int. University","2024",R.drawable.miu))

        certificationArrayList=ArrayList<CertificationModel>()
        certificationArrayList.add(CertificationModel("AWS Solution Architect","Amazon Academy","2020",R.drawable.aws))
        certificationArrayList.add(CertificationModel("Azure Database Administration","Azure Academy","2015",R.drawable.azure))


        try {
            var eduListView: ListView = view.findViewById(R.id.educationListView)
            var certListView: ListView = view.findViewById(R.id.certificationListView)

            eduListView.adapter = EducationAdapter(view.context as Activity, educationArrayList)
            certListView.adapter = CertificationAdapter(view.context as Activity, certificationArrayList)

        }
        catch (exp:java.lang.Exception
        ){}
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}