package com.tirtho.com.tirtho.account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AccountServices {
    @GET("student_account_info_summary/9892?token=eyJpdiI6Ik45dlRjUzFhQzloZ3NwTGVGd1h6aFE9PSIsInZhbHVlIjoiaGlaQTFxYkVHektLRmVxdnZLZVJGYUdXazRhTzVrVjVST2MyZVdBYlVyYVRhd1RYbjNmQTRQZHBXRWZiMEhOd2RaTzkyRG1PTlpKNUt4bVFCWmlFTHFOSU1mYllhWTJMcEIxVFl5bHpndzRtaTk5b3BqcTlsU29DNGZWbWk2NE4iLCJtYWMiOiIzMDk4NjdhNGRhNzQwMmE4MzMwMTk5ZDVhYzUxY2RlZGZhOWI1NmQ4YmI2MDA1ZTdhYzU0NzU4ODk3MTk3NGJkIn0=")
    Call<AccountSummry> getSummery();
}