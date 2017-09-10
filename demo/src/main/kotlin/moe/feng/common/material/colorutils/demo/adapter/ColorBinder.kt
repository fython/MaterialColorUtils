package moe.feng.common.material.colorutils.demo.adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import moe.feng.common.material.colorutils.ColorLevel
import moe.feng.common.material.colorutils.ColorName
import moe.feng.common.material.colorutils.demo.R
import moe.feng.common.material.colorutils.MaterialColors

class ColorBinder: ModelBindAdapter.ModelBinder<ColorName>() {

	private val ModelBindAdapter.ViewHolder.title by autoBindView<TextView>(android.R.id.title)
	private val ModelBindAdapter.ViewHolder.list by autoBindView<RecyclerView>(android.R.id.list)

	override fun onViewCreated(view: View, holder: ModelBindAdapter.ViewHolder) {
		super.onViewCreated(view, holder)
		holder.list.layoutManager = LinearLayoutManager(
				holder.context, LinearLayoutManager.HORIZONTAL, false)
		holder.list.adapter = ModelBindAdapter(LevelBinder())
	}

	override fun onBind(holder: ModelBindAdapter.ViewHolder, data: ColorName) {
		holder.title.text = data.name
		(holder.list.adapter as? ModelBindAdapter<Int>)?.items = ColorLevel.values().map { brightness ->
			MaterialColors[data][brightness]
		}.toMutableList()
		holder.list.adapter.notifyDataSetChanged()
	}

	override fun getLayoutId(): Int = R.layout.color_item

}