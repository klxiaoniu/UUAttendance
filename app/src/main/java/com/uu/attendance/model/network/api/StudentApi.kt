package com.uu.attendance.model.network.api

import com.uu.attendance.model.network.RetrofitProvider
import com.uu.attendance.model.network.dto.NewAttendanceAppealDto
import com.uu.attendance.model.network.dto.NewLeaveApplicationDto
import com.uu.attendance.model.network.dto.SignInDto
import com.uu.attendance.model.network.service.StudentService

object StudentApi {
    private val studentService by lazy {
        RetrofitProvider.getRetrofit(true).create(StudentService::class.java)
    }

    suspend fun getCourseTable(week: Int, semester: Int) = studentService.getCourseTable(week, semester)

    suspend fun getLeaveApplicationList() = studentService.getLeaveApplicationList()

    suspend fun getAttendanceAppealList() = studentService.getAttendanceAppealList()

    suspend fun getSemesterAndSchoolOpenTime() = studentService.getSemesterAndSchoolOpenTime()

    suspend fun postLeaveApplication(body: NewLeaveApplicationDto) = studentService.postLeaveApplication(body)

    suspend fun postAttendanceAppeal(body: NewAttendanceAppealDto) = studentService.postAttendanceAppeal(body)

    suspend fun signIn(body: SignInDto) = studentService.signIn(body)
}