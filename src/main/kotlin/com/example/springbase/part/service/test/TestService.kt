package com.example.springbase.part.service.test

import com.example.springbase.fwk.base.BaseService
import org.springframework.stereotype.Service

/**
 * 21.01.05 | gomip | created
 */
@Service
class TestService : BaseService(){
    fun testService() : String{
        return "test"
    }
}