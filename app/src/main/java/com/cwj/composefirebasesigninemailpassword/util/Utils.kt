package com.cwj.composefirebasesigninemailpassword.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.cwj.composefirebasesigninemailpassword.util.Constants.TAG

fun printE(e: Exception) = Log.e(TAG, e.stackTraceToString())

fun makeToast(ctx: Context, msg: String) =
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
