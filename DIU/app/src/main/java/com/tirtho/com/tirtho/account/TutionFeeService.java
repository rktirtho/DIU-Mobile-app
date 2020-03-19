package com.tirtho.com.tirtho.account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface TutionFeeService {
    @GET("student_account_info_summary/9892?token=eyJpdiI6IkNJcWJZRjR3ZnZ2WTJWZFBiMWgrcUE9PSIsInZhbHVlIjoiT0tod2lYMHVFb1djUG5rUFo0ZDdTVkVmTzVXYWVHMjVFekZvWUtnUmFJTXF5T2tuUHo1ZXN0QXRiRktnZjBvNVlXbVJGc0ZabEJ1N2xuNGVQM3llQk9lb1Q2d3FUNFZOcUh6dzFIelhuQnRNMkgwaHBWWlk0cTM1S2FYc3lcLzBWIiwibWFjIjoiMjIzMjUzNmU0NjkyNjc3MGE5YWRiZGYyMjM1NzdiMDg4YmY3MzM4ZWQ2Y2ZhMmJjYWE5M2I0MGY2NjBhMjAyZiJ9")
    Call<List<TuitionFee>> getAll();


}
