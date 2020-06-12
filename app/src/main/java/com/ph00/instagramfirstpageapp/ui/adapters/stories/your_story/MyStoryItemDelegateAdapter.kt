package com.ph00.instagramfirstpageapp.ui.adapters.stories.your_story

import com.example.delegateadapter.delegate.KDelegateAdapter
import com.ph00.instagramfirstpageapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_story.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class MyStoryItemDelegateAdapter(
    private val onItemClick: ((String) -> Unit)
) :
    KDelegateAdapter<MyStoryItemViewModel>(), KoinComponent {

    private val picasso by inject<Picasso>()

    override fun getLayoutId() = R.layout.item_my_story

    override fun isForViewType(items: MutableList<*>, position: Int) =
        items[position] is MyStoryItemViewModel

    override fun onBind(item: MyStoryItemViewModel, viewHolder: KViewHolder) {
        picasso.load(item.story.storyImgUrl).into(viewHolder.story_img)
        viewHolder.story_img.setOnClickListener { onItemClick(item.story.storyImgUrl) }
        viewHolder.story_username_text.text = item.story.userName
    }
}