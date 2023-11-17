package com.example.springdemo.base

data class AjaxResponse(val code: Int, val message: String, val isSuccess: Boolean, val data: Any?) {

    companion object {
        fun createSuccessResponse(data: Any?): AjaxResponse {
            return AjaxResponse(200, "success", true, data)
        }

        fun createFailureResponse(code: Int, msg: String, data: Any?): AjaxResponse {
            return AjaxResponse(code, msg, false, data)
        }
    }


}