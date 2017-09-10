package moe.feng.common.material.colorutils.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import moe.feng.common.material.colorutils.ColorName
import moe.feng.common.material.colorutils.demo.adapter.ColorBinder
import moe.feng.common.material.colorutils.demo.adapter.ModelBindAdapter

class SampleActivity : AppCompatActivity() {

	private val listView: RecyclerView by lazy { findViewById<RecyclerView>(android.R.id.list) }

	private val adapter = ModelBindAdapter(ColorBinder())

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_sample)

		listView.layoutManager = LinearLayoutManager(this)
		listView.adapter = adapter
		adapter.items = ColorName.values().toMutableList()
	}

}
