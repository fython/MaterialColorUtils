package moe.feng.common.material.colorutils.demo

import android.app.Application
import moe.feng.common.material.colorutils.MaterialColors

class DemoApplication: Application() {

	override fun onCreate() {
		super.onCreate()
		MaterialColors.init(this)
	}

}