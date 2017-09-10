package moe.feng.common.material.colorutils

import android.app.Application
import android.content.Context
import android.content.res.Resources

object MaterialColors {

	private lateinit var context: Context

	fun init(app: Application) {
		context = app.applicationContext
	}

	operator fun get(colorName: ColorName): MaterialColorGetter = MaterialColorGetter(colorName)

	fun getColorId(colorName: ColorName, brightness: ColorLevel = ColorLevel.`500`): Int {
		val resourceId = context.resources.getIdentifier(
				"material_${colorName.value}_${brightness.value}",
				"color",
				context.packageName
		)
		return resourceId
	}

	fun getColorInt(colorName: ColorName, brightness: ColorLevel): Int {
		return try {
			context.resources.getColor(getColorId(colorName, brightness))
		} catch (e: Resources.NotFoundException) {
			0x00000000
		}
	}

	fun parseIdToColor(id: Int): ColorName {
		ColorName.values().forEach { color ->
			ColorLevel.values().forEach { brightness ->
				if (getColorId(color, brightness) == id) {
					return color
				}
			}
		}
		throw IllegalArgumentException("Unsupported color resource id.")
	}


	fun parseStringToColor(value: String): ColorName = ColorName.values().find { it.value == value }!!

	class MaterialColorGetter internal constructor(private val colorName: ColorName) {
		operator fun get(brightness: ColorLevel): Int = getColorInt(colorName, brightness)
	}

}