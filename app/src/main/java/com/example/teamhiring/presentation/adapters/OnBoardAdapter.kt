package com.example.teamhiring.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.teamhiring.data.models.OnBoardData
import com.example.teamhiring.databinding.ItemOnboardingScreenBinding

class OnBoardAdapter (val imageList: List<OnBoardData>) : RecyclerView.Adapter<OnBoardAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemOnboardingScreenBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(item:OnBoardData){
                binding.imageView.setImageResource(item.image)
                binding.title.text = item.title
                binding.desc.text = item.desc
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemOnboardingScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item  = imageList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = imageList.size
}


//    override fun getCount(): Int {
//        return imageList.size
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view === `object` as ConstraintLayout
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//
//        val mLayoutInflater =
//            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//
//
//        val itemView: View = mLayoutInflater.inflate(R.layout.item_onboarding_screen, container, false)
//
//
//        val imageView: ImageView = itemView.findViewById<View>(R.id.imageView) as ImageView
//
//
//        imageView.setImageResource(imageList.get(position))
//
//        Objects.requireNonNull(container).addView(itemView)
//
//
//        return itemView
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as ConstraintLayout)
//

//}

