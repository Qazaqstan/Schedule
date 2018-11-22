package com.testproject.schedule;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.testproject.schedule.API.ScheduleService;
import com.testproject.schedule.Model.Classroom;
import com.testproject.schedule.Remote.EventWeekService;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.tobiasschuerg.weekview.data.Event;
import de.tobiasschuerg.weekview.data.EventConfig;
import de.tobiasschuerg.weekview.data.WeekData;
import de.tobiasschuerg.weekview.view.EventView;
import de.tobiasschuerg.weekview.view.WeekView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EventConfig eventConfig = null;
    private WeekView weekView = null;
    private WeekData weekData = new WeekData();

    private Classroom[] classrooms;

    @BindView(R.id.nameOfClassroom) TextView nameClassroom;
    @BindView(R.id.teacherName) TextView teacherName;
    @BindView(R.id.teacherPosition) TextView teacherPosition;
    @BindView(R.id.description) TextView description;
    @BindView(R.id.teacherImg) ImageView imageView;
    @BindView(R.id.cardView) CardView cardView;
    @BindView(R.id.btnClose) ImageView btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        classrooms = new Classroom[]{};

        eventConfig = new EventConfig();
        weekView = findViewById(R.id.weekView);
        weekView.setEventConfig(eventConfig);
        registerForContextMenu(weekView);

        description.setMovementMethod(new ScrollingMovementMethod());

        ScheduleService service = EventWeekService.getClient().create(ScheduleService.class);
        Call<Classroom[]> call = service.getPhoneBook();
        call.enqueue(new Callback<Classroom[]>() {
            @Override
            public void onResponse(Call<Classroom[]> call, Response<Classroom[]> response) {
                if (response.isSuccessful()) {
                    classrooms = response.body();
                    updateWeekView();
                }
            }

            @Override
            public void onFailure(Call<Classroom[]> call, Throwable t) {
                Log.d("myERROR", t.getMessage());
            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.GONE);
            }
        });

        weekView.setLessonClickListener(new Function1<EventView, Unit>() {
            @Override
            public Unit invoke(EventView eventView) {
                for (Classroom classroom : classrooms) {
                    if (classroom.getAppointment_id().hashCode() == eventView.getEvent().getId()) {
                        cardView.setVisibility(View.VISIBLE);
                        nameClassroom.setText(classroom.getName());
                        teacherName.setText(classroom.getTeacher_v2().getName());
                        teacherPosition.setText(classroom.getTeacher_v2().getPosition());
                        description.setText(classroom.getDescription());
                        Glide.with(MainActivity.this).load(classroom.getTeacher_v2().getImageUrl()).into(imageView);
                        break;
                    }
                }
                return null;
            }
        });

    }

    private void updateWeekView() {
        for (Classroom classroom : classrooms) {
            String[] startTimeClassrom = classroom.getStartTime().split("\\.");
            String[] endTimeClassrom = classroom.getEndTime().split("\\.");

            LocalTime startTime = LocalTime.of(Integer.parseInt(startTimeClassrom[0]), Integer.parseInt(startTimeClassrom[1]));
            LocalTime endTime = LocalTime.of(Integer.parseInt(endTimeClassrom[0]), Integer.parseInt(endTimeClassrom[1]));

            Event.Single single = new Event.Single(classroom.getAppointment_id().hashCode(), LocalDate.now(), "",  classroom.getName(), "", classroom.getWeekDay() + 1, startTime, endTime, null, null, Color.WHITE, Color.parseColor(classroom.getColor()));
            weekData.add(single);
        }
        weekView.addLessonsToTimetable(weekData);
        registerForContextMenu(weekView);
    }
}