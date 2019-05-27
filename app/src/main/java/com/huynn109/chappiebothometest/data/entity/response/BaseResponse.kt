package com.trio.driver.data.entity.response

import com.google.gson.annotations.SerializedName

/**
 * Created by huynn109 on 2019-05-09.
 */
abstract class BaseResponse ( @SerializedName("code")
                          var code: Int? = -1,
                          @SerializedName("message")
                          var message: String? = null)