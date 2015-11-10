package com.tohamy.materialhijricalendarview.sample.decorators;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.tohamy.materialhijricalendarview.CalendarDay;
import com.tohamy.materialhijricalendarview.DayViewDecorator;
import com.tohamy.materialhijricalendarview.DayViewFacade;

import java.util.Calendar;

/**
 * Highlight Saturdays and Sundays with a background
 */
public class HighlightWeekendsDecorator implements DayViewDecorator {

    private final UmmalquraCalendar calendar = new UmmalquraCalendar();
    private final Drawable highlightDrawable;
    private static final int color = Color.parseColor("#228BC34A");

    public HighlightWeekendsDecorator() {
        highlightDrawable = new ColorDrawable(color);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(highlightDrawable);
    }
}