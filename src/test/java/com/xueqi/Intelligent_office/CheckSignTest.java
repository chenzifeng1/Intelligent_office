//package com.xueqi.Intelligent_office;
//
//import com.xueqi.Intelligent_office.model.Attendance;
//import com.xueqi.Intelligent_office.service.AttendanceService;
//
//import com.xueqi.Intelligent_office.service.Judge;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//public class CheckSignTest {
//    @Mock private AttendanceService attendanceService;
//    @Mock private Attendance attendance;
//
//    @BeforeTest
//
//    public void setUp() throws Exception {
//        attendance = new Attendance(2,1,2);
//        when(attendanceService.isPresent(2)).thenReturn(true);
//        when(attendanceService.findOne(2)).thenReturn(attendance);
//        when(attendanceService.create(2,1))
//                .thenReturn(new Attendance(1,1,2))
//                .thenThrow(new NullPointerException())
//                .thenThrow(new Exception());
//
//    }
//
//
//    @Test
//    public void checkSign(){
//        attendanceService.create(2,1);
//
//    }
//}
