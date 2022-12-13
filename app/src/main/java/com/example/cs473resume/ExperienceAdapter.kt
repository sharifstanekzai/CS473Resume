package com.example.cs473resume

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ExperienceAdapter(private val context: Activity, private val arrayList:ArrayList<ExperienceModel>):
    ArrayAdapter<ExperienceModel>(context,R.layout.list_item,arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item,null)

        val img: ImageView = view.findViewById(R.id.imgIcon)
        val heading: TextView =view.findViewById(R.id.itemHeading)
        val summary: TextView =view.findViewById(R.id.itemSummary)
        val details: TextView =view.findViewById(R.id.itemDetails)

        img.setImageResource(arrayList[position].imgID)
        heading.text = arrayList[position].title
        summary.text = arrayList[position].employer
        details.text = arrayList[position].year

        return view
    }
}