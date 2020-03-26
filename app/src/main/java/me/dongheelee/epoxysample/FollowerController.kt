package me.dongheelee.epoxysample

import android.content.Context
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel

class FollowerController(private val context: Context) : TypedEpoxyController<List<User>>() {

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    override fun buildModels(users: List<User>?) {
        itemHeader {
            id("ItemHeader")
        }

        if (users.isNullOrEmpty()) {
            return
        }

        val powerUsers = users.filter { it.followerCount >= (0..100).random() }

        if (powerUsers.isNotEmpty()) {
            carousel {
                id("Power User Carousel")
                paddingRes(R.dimen.item_power_user_horizontal_margin)
                models(
                    powerUsers
                        .map {
                            val thumbnailDrawable = context.resources.getIdentifier(
                                it.thumbnail,
                                "drawable",
                                context.packageName
                            )
                            ItemPowerUserBindingModel_()
                                .id("ItemPowerUser-${it.id}")
                                .name(it.name)
                                .thumbnail(thumbnailDrawable)
                        }
                )
            }
        } else {
            itemMessage {
                id("Item Message")
                message("Power user not exist")
            }
        }

        users.forEach {
            itemFollower {
                id("ItemFollower-${it.id}")
                name(it.name)
                val thumbnailDrawable = context.resources.getIdentifier(
                    it.thumbnail,
                    "drawable",
                    context.packageName
                )
                thumbnail(thumbnailDrawable)
            }
        }
    }
}