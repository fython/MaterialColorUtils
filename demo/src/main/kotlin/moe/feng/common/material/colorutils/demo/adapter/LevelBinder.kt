package moe.feng.common.material.colorutils.demo.adapter

import moe.feng.common.material.colorutils.demo.R

class LevelBinder : ModelBindAdapter.ModelBinder<Int>() {

	override fun onBind(holder: ModelBindAdapter.ViewHolder, data: Int) {
		holder.itemView.setBackgroundColor(data)
	}

	override fun getLayoutId(): Int = R.layout.brightness_item

}