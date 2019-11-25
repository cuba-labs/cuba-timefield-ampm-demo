package com.company.sample.web.screens;

import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

@UiController("sample_TestScreen")
@UiDescriptor("test-screen.xml")
public class TestScreen extends Screen {

    @Inject
    private TimeField<Date> timeField;
    @Inject
    private DateField<Date> dateField;

    @Inject
    private Label<String> timeFieldValue;
    @Inject
    private Label<String> dateFieldValue;

    @Subscribe("timeField")
    public void onTimeFieldValueChange(HasValue.ValueChangeEvent<Date> event) {
        timeFieldValue.setValue(event.getValue() != null ? event.getValue().toString() : "");
    }

    @Subscribe("dateField")
    public void onDateFieldValueChange(HasValue.ValueChangeEvent<Date> event) {
        dateFieldValue.setValue(event.getValue() != null ? event.getValue().toString() : "");
    }

    @Subscribe("tfTimeMode")
    public void onTfTimeModeClick(Button.ClickEvent event) {
        TimeField.TimeMode timeMode = timeField.getTimeMode() == TimeField.TimeMode.H_12
                ? TimeField.TimeMode.H_24
                : TimeField.TimeMode.H_12;
        timeField.setTimeMode(timeMode);
    }

    @Subscribe("dfTimeMode")
    public void onDfTimeModeClick(Button.ClickEvent event) {
        TimeField.TimeMode timeMode = dateField.getTimeMode() == TimeField.TimeMode.H_12
                ? TimeField.TimeMode.H_24
                : TimeField.TimeMode.H_12;
        dateField.setTimeMode(timeMode);
    }

    @Subscribe("setTfValue")
    public void onSetTfValueClick(Button.ClickEvent event) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 45);

        timeField.setValue(cal.getTime());
    }

    @Subscribe("setDfValue")
    public void onSetDfValueClick(Button.ClickEvent event) {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR_OF_DAY, 13);
        cal.set(Calendar.MINUTE, 45);

        dateField.setValue(cal.getTime());
    }
}