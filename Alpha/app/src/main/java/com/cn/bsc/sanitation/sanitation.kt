package com.cn.bsc.sanitation

import android.widget.Toast
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail

class Sanitation {
    var emailStr = "john.doe@gmail.com"
    var isValid = emailStr.validEmail()



}