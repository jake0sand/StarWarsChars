package com.jakey.starwarsimages.utils

import javax.inject.Inject

object HelperFuns {

    fun lastSegment(s:String) = s.split("/").dropLast(1).last()
}


class HelperFuns2 @Inject constructor() {
    fun lastSegment(s:String) = s.split("/").dropLast(1).last().toInt()
}