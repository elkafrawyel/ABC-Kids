package com.app.abc.sings

import com.app.abc.R
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

class SingsAdapter :
    BaseQuickAdapter<Sing, BaseViewHolder>(R.layout.sing_item_view) {

    override fun convert(helper: BaseViewHolder, item: Sing) {
        Glide.with(mContext).load(item.image).into(helper.getView(R.id.image))

        helper.setText(R.id.name, item.name)

        helper.addOnClickListener(R.id.singItem)
    }

}