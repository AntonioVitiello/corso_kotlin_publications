package ant.vit.publications.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ant.vit.publications.R
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.tools.isPair
import ant.vit.publications.tools.loadImage
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by Vitiello Antonio
 */
class PostListAdapter : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {
    private val mPublicationModels = mutableListOf<PublicationModel>()

    companion object {
        const val TAG = "PostListAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = mPublicationModels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindItem(mPublicationModels[position], position)

    fun switchData(data: List<PublicationModel>?) {
        mPublicationModels.clear()
        if (data != null) {
            mPublicationModels.addAll(data)
        }
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(model: PublicationModel, position: Int) {
            with(itemView) {
                if (position.isPair()) {
                    val color = ContextCompat.getColor(context, R.color.item_pair)
                    setBackgroundColor(color)
                } else {
                    val color = ContextCompat.getColor(context, R.color.item_odd)
                    setBackgroundColor(color)
                }
                userIdText.text = itemView.context.getString(R.string.user_id, model.id?.toString())
                titleText.text = model.title
                descriptionText.text = model.description
                postImage.loadImage(model.imageUrl)
                publishDateText.text =
                    itemView.context.getString(R.string.post_date, model.publishDateString)
            }
        }

    }

}